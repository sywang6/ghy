package org.ghy.scoketAndNio.ch05.ch08_08;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test301 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
            serverSocketChannel1.bind(new InetSocketAddress("localhost",7777));
            serverSocketChannel1.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey1 = serverSocketChannel1.register(selector,SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun == true){
                int keyCount = selector.select();
                Set<SelectionKey> set1 = selector.keys();
                Set<SelectionKey> set2 = selector.selectedKeys();
                System.out.println("keyCountA="+keyCount);
                System.out.println("set1 size="+set1.size());
                System.out.println("set2 size="+set2.size());
                System.out.println();
                Iterator<SelectionKey> iterator = set2.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    SelectionKey key2 = socketChannel.register(selector,SelectionKey.OP_READ);
                    System.out.println("key2.isReadable()="+((SelectionKey.OP_READ & ~key2.interestOps()) == 0 ));
                    System.out.println("key2.isWritable()="+((SelectionKey.OP_WRITE & ~key2.interestOps()) == 0 ));

                    //同一个通道重复注册到同一个选择器,返回的SelectionKey是同一个,但是会覆盖感兴趣的事件
                    SelectionKey key3 = socketChannel.register(selector,SelectionKey.OP_WRITE | SelectionKey.OP_READ);
                    System.out.println("key3.isReadable()="+((SelectionKey.OP_READ & ~key2.interestOps()) == 0 ));
                    System.out.println("key3.isWritable()="+((SelectionKey.OP_WRITE & ~key2.interestOps()) == 0 ));

                    System.out.println("keyCountB ="+keyCount);
                    System.out.println("set1 size="+set1.size());
                    System.out.println("set2 size="+set2.size());
                    System.out.println("key2=key3结果:"+(key2 == key3));
                }
                Thread.sleep(Integer.MAX_VALUE);
            }
            serverSocketChannel1.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
