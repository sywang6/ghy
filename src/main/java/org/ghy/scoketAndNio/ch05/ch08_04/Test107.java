package org.ghy.scoketAndNio.ch05.ch08_04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test107 {
    public static void main(String[] args){
        try {
            ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
            serverSocketChannel1.bind(new InetSocketAddress("localhost",7777));
            serverSocketChannel1.configureBlocking(false);

            ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
            serverSocketChannel2.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel2.configureBlocking(false);

            Selector selector1 = Selector.open();

            SelectionKey selectionKey1 = serverSocketChannel1.register(selector1,SelectionKey.OP_ACCEPT);
            SelectionKey selectionKey2 = serverSocketChannel2.register(selector1,SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun == true){
                int keyCount = selector1.select();
                //所有事件
                Set<SelectionKey> set1 = selector1.keys();
                //已就绪的事件
                Set<SelectionKey> set2 = selector1.selectedKeys();
                System.out.println("keyCount="+keyCount);
                System.out.println("set1 size="+set1.size());
                System.out.println("set2 size="+set2.size());
                Iterator<SelectionKey> iterator = set2.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    InetSocketAddress ipAddress = (InetSocketAddress)serverSocketChannel.getLocalAddress();
                    System.out.println(ipAddress.getPort()+" 被客户端连接了! ");
                    System.out.println();
                    //已就绪的事件已经处理完成,移除之
                    iterator.remove();
                }
            }
            serverSocketChannel1.close();
            serverSocketChannel2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
