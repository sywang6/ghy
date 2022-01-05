package org.ghy.scoketAndNio.ch04.section02.ch02_11;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost",8088));
            //获取ServerSocket的IP地址信息
            System.out.println(serverSocket.getInetAddress().getHostAddress());
            System.out.println(serverSocket.getInetAddress().isLoopbackAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
