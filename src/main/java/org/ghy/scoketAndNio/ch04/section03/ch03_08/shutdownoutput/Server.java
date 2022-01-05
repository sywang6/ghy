package org.ghy.scoketAndNio.ch04.section03.ch03_08.shutdownoutput;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            //判断OutputStream是否已经开启(半写)
            System.out.println("C socket.isOutputShutdown()="+socket.isOutputShutdown());
            socket.shutdownOutput();
            System.out.println("D socket.isOutputShutdown()="+socket.isOutputShutdown());
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
