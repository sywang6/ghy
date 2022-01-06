package org.ghy.scoketAndNio.ch05.ch07_21;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ConnectServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.close();
            serverSocketChannel.close();
            System.out.println("server end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
