package org.ghy.scoketAndNio.ch05.ch07_09;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test1 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            System.out.println("A isBlocking="+serverSocketChannel.isBlocking());
            serverSocketChannel.configureBlocking(false);
            System.out.println("B isBlocking="+serverSocketChannel.isBlocking());

            Selector selector = Selector.open();
            System.out.println("selector="+selector);
            System.out.println("C serverSocketChannel.isRegistered()="+serverSocketChannel.isRegistered());
            //ServerSocketChannel必须是非阻塞的才能注册到选择器上
            SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println("D serverSocketChannel.isRegistered()="+serverSocketChannel.isRegistered());
            //已经配置为非阻塞模式.并且已经注册到选择器上,在设置为阻塞模式将抛出异常
            //serverSocketChannel.configureBlocking(true);
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
