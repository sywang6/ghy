package org.ghy.scoketAndNio.ch04.section03.ch03_04;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            //获取本端InetAddress
            InetAddress inetAddress = socket.getLocalAddress();
            //获取本端InetSocketAddress
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getLocalSocketAddress();
            byte[] byteArray1 = inetAddress.getAddress();
            System.out.println("服务端的IP地址为:");
            for (int i = 0; i < byteArray1.length; i++) {
                System.out.print(byteArray1[i]+" ");
            }
            System.out.println();
            System.out.println("服务端的端口为:"+inetSocketAddress.getPort());
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
