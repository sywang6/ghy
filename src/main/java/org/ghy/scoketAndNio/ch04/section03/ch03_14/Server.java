package org.ghy.scoketAndNio.ch04.section03.ch03_14;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("server begin");
            Socket socket = serverSocket.accept();
            System.out.println("server end");
            Thread.sleep(Integer.MAX_VALUE);
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
