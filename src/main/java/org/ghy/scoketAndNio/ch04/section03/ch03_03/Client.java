package org.ghy.scoketAndNio.ch04.section03.ch03_03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            socket.bind(new InetSocketAddress("localhost",7777));
            socket.connect(new InetSocketAddress("localhost",8888));
            System.out.println("客户端的输出:");
            //getLocalPort()获得本端的端口号
            System.out.println("客户端的端口号:socket.getLocalPort="+socket.getLocalPort());
            //getPort()获得对端的端口号
            System.out.println("服务端的端口号:socket.getPort="+socket.getPort());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
