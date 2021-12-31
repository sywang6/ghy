package org.ghy.scoketAndNio.ch04.ch02_10;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

public class Server2 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            System.out.println("bind begin "+serverSocket.isBound());
            //www.baidufasfsfs.com不能解析,所有ServerSocket是bind不上去的,会抛出异常
            serverSocket.bind(new InetSocketAddress("www.baidufasfsfs.com",8888));
            System.out.println("bind end "+serverSocket.isBound());



        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ServerSocket serverSocket = new ServerSocket();
            System.out.println("bind begin "+serverSocket.isBound());
            //inetSocketAddress3是一个未解析的InetSocketAddress,ServerSocket也是绑定不上去的
            InetSocketAddress inetSocketAddress3 = InetSocketAddress.createUnresolved("localhost",80);
            serverSocket.bind(inetSocketAddress3,8888);
            System.out.println("bind end "+serverSocket.isBound());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
