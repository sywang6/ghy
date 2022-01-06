package org.ghy.scoketAndNio.ch05.ch07_08;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test0 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            Selector selector = Selector.open();
            System.out.println("selector="+selector);
            System.out.println("A serverSocketChannel.isRegistered()="+serverSocketChannel.isRegistered());
            //ServerSocketChannel必须是非阻塞的才能注册到选择器上
            SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println("B serverSocketChannel.isRegistered()="+serverSocketChannel.isRegistered());
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
