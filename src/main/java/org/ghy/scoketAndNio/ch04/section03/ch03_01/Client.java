package org.ghy.scoketAndNio.ch04.section03.ch03_01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket  = new Socket();
            //Socket绑定特定的端口
            socket.bind(new InetSocketAddress("localhost",7777));
            socket.connect(new InetSocketAddress("localhost",8888));
            socket.close();
            System.out.println("client end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
