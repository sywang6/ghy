package org.ghy.scoketAndNio.ch04.section03.ch03_08.shutdowninput;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            //判断InputStream是否已经开启(半读)
            System.out.println("A isInputShutdown="+socket.isInputShutdown());
            socket.shutdownInput();
            System.out.println("B isInputShutdown="+socket.isInputShutdown());
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
