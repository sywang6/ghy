package org.ghy.scoketAndNio.ch04.section02.ch02_12.serverPortReuse;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test3 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("172.16.16.148",8888));
            System.out.println("accept begin");
            Socket socket = serverSocket.accept();
            System.out.println("accept end");
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
