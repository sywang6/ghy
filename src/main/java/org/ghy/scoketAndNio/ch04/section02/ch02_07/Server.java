package org.ghy.scoketAndNio.ch04.section02.ch02_07;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            System.out.println("new ServerSocket()无参构造的端口是:"+serverSocket.getLocalPort());
            serverSocket.bind(new InetSocketAddress("172.16.16.148",8888));
            System.out.println("调用bind方法之后的端口是:"+serverSocket.getLocalPort());
            //获取本地SocketAdress对象及本地端口
            InetSocketAddress inetSocketAddress = (InetSocketAddress) serverSocket.getLocalSocketAddress();
            System.out.println("inetSocketAddress.getHostName()"+inetSocketAddress.getHostName());
            System.out.println("inetSocketAddress.getHostString()"+inetSocketAddress.getHostString());
            System.out.println("inetSocketAddress.getPort()"+inetSocketAddress.getPort());
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
