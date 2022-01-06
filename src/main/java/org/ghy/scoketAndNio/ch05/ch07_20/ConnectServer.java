package org.ghy.scoketAndNio.ch05.ch07_20;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ConnectServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
            serverSocketChannel1.bind(new InetSocketAddress("localhost",8088));
            SocketChannel socketChannel = serverSocketChannel1.accept();
            socketChannel.close();
            serverSocketChannel1.close();
            System.out.println("server end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
