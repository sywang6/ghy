package org.ghy.scoketAndNio.ch05.ch08_02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test103 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun == true){
                int keyCount = selector.select();
                Set<SelectionKey> set1 = selector.keys();
                Set<SelectionKey> set2 = selector.selectedKeys();
                System.out.println("keyCount="+keyCount);
                System.out.println("set1 size="+set1.size());
                System.out.println("set2 size="+set2.size());
                System.out.println();
                Iterator<SelectionKey> iterator = set2.iterator();
                //处理已经就绪的事件
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                    channel.accept();
                }
            }
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
