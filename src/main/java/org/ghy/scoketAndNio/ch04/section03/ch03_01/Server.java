package org.ghy.scoketAndNio.ch04.section03.ch03_01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            socket.close();
            serverSocket.close();
            System.out.println("server end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
