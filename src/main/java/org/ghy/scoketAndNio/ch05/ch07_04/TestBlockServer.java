package org.ghy.scoketAndNio.ch05.ch07_04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TestBlockServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //阻塞模式
            System.out.println(serverSocketChannel.isBlocking());
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            System.out.println("begin "+System.currentTimeMillis());
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("end "+System.currentTimeMillis());
            socketChannel.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
