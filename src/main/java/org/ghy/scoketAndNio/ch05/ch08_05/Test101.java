package org.ghy.scoketAndNio.ch05.ch08_05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test101 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
            serverSocketChannel1.bind(new InetSocketAddress("localhost",7777));
            serverSocketChannel1.configureBlocking(false);

            ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
            serverSocketChannel2.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel2.configureBlocking(false);

            Selector selector = Selector.open();
            SelectionKey selectionKey1 = serverSocketChannel1.register(selector,SelectionKey.OP_ACCEPT);
            SelectionKey selectionKey2 = serverSocketChannel2.register(selector,SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun == true){
                int keyCount = selector.select();
                //多次循环set1和set2为同一个对象
                Set<SelectionKey> set1 = selector.keys();
                Set<SelectionKey> set2 = selector.selectedKeys();
                System.out.println("set1 size="+set1.size()+" set1 hashCode="+set1.hashCode());
                System.out.println("set2 size="+set2.size()+" set2 hashCode="+set2.hashCode());
                System.out.println();
                Iterator<SelectionKey> iterator = set2.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
                    serverSocketChannel.accept();
                }
            }
            serverSocketChannel1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
