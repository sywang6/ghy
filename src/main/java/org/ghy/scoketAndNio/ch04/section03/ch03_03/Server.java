package org.ghy.scoketAndNio.ch04.section03.ch03_03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("服务端的输出:");
            //getLocalPort()获得本端的端口号
            System.out.println("服务端的端口号:"+"socket.getLocalPort()="+socket.getLocalPort());
            //getPort()获得对端的端口号
            System.out.println("客户端的端口号:"+"socket.getPort()="+socket.getPort());
            socket.close();
            serverSocket.close();
            System.out.println("server end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
