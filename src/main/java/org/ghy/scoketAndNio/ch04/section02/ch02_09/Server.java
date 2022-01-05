package org.ghy.scoketAndNio.ch04.section02.ch02_09;

import java.io.IOException;
import java.net.ServerSocket;

//关闭ServerSocket与获取关闭状态
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println(serverSocket.isClosed());
            serverSocket.close();
            System.out.println(serverSocket.isClosed());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
