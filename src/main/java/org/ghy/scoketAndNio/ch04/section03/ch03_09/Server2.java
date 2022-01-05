package org.ghy.scoketAndNio.ch04.section03.ch03_09;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("A="+socket.getTcpNoDelay());
            socket.setTcpNoDelay(false);
            System.out.println("B="+socket.getTcpNoDelay());
            OutputStream outputStream = socket.getOutputStream();
            for (int i = 0; i < 50000; i++) {
                outputStream.write("1".getBytes());
            }
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
