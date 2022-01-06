package org.ghy.scoketAndNio.ch05.ch07_15;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class Test6_isBlockingTest {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            //阻塞模式判断
            System.out.println(serverSocketChannel.isBlocking());
            serverSocketChannel.configureBlocking(false);
            System.out.println(serverSocketChannel.isBlocking());
            serverSocketChannel.close();
            System.out.println(serverSocketChannel.isBlocking());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
