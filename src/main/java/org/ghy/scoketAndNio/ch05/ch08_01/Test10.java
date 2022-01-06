package org.ghy.scoketAndNio.ch05.ch08_01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test10 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            System.out.println("1");
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            System.out.println("2");
            serverSocketChannel.configureBlocking(false);
            System.out.println("3");
            Selector selector = Selector.open();
            System.out.println("4");
            SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println("5");
            //没有任何感兴趣的事件(accept事件)发生时,select()是阻塞的
            int keyCount = selector.select();
            System.out.println(" 6 keyCount="+keyCount);
            serverSocketChannel.close();
            System.out.println("7  end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
