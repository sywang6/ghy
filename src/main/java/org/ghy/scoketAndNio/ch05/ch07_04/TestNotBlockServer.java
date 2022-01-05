package org.ghy.scoketAndNio.ch05.ch07_04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TestNotBlockServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //非阻塞模式
            System.out.println(serverSocketChannel.isBlocking());
            serverSocketChannel.configureBlocking(false);
            System.out.println(serverSocketChannel.isBlocking());
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            System.out.println("begin "+System.currentTimeMillis());
            //没有连接返回null
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println("end "+System.currentTimeMillis()+" socketChannel"+socketChannel);
            socketChannel.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
