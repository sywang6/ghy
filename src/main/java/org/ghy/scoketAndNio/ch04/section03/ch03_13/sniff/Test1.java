package org.ghy.scoketAndNio.ch04.section03.ch03_13.sniff;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
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
