package org.ghy.scoketAndNio.ch04.section03.ch03_05;

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
            //获取对端InetAddress
            InetAddress inetAddress = socket.getInetAddress();
            //获取对端InetSocketAddress
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            byte[] byteArray1 = inetAddress.getAddress();
            System.out.println("客户端的IP地址为:");
            for (int i = 0; i < byteArray1.length; i++) {
                System.out.print(byteArray1[i]+" ");
            }
            System.out.println();
            System.out.println("客户端的端口为:"+inetSocketAddress.getPort());
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
