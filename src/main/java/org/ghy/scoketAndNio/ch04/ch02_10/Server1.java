package org.ghy.scoketAndNio.ch04.ch02_10;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Server1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            System.out.println("bind begin "+serverSocket.isBound());
            serverSocket.bind(new InetSocketAddress("localhost",8888));
            System.out.println("bind end "+serverSocket.isBound());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
