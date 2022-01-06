package org.ghy.scoketAndNio.ch05.ch08_02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

public class Test101 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun == true){
                //先运行Test101,在运行Test102,将会出现死循环,原因是Selector里有未处理的事件
                int keyCount = selector.select();
                Set<SelectionKey> set1 = selector.keys();
                Set<SelectionKey> set2 = selector.selectedKeys();
                System.out.println("keyCount="+keyCount);
                System.out.println("set1 size="+set1.size());
                System.out.println("set2 size="+set2.size());
                System.out.println();
            }
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
