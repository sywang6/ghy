package org.ghy.scoketAndNio.ch04.ch02_05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            //先创建serverSocket在绑定到指定的Socket地址
            serverSocket.bind(new InetSocketAddress(8888));
            System.out.println("server begin accept");
            serverSocket.accept();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
