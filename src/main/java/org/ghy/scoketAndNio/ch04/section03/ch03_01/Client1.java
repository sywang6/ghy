package org.ghy.scoketAndNio.ch04.section03.ch03_01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            System.out.println("A="+socket.getLocalPort());
            //Socket没有指定特定的端口,随机一个端口进行绑定
            socket.connect(new InetSocketAddress("localhost",8088));
            System.out.println("B="+socket.getLocalPort());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
