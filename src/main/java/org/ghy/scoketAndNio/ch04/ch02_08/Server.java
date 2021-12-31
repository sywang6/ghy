package org.ghy.scoketAndNio.ch04.ch02_08;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            InetAddress inetAddress = InetAddress.getByName("localhost");
            //构造方法InetSocketAddress(InetAddress addr, int port)的使用,从构造方法我们也可以推断
            //InetSocketAddress是InetAddress+端口
            InetSocketAddress inetSocketAddress = new InetSocketAddress(inetAddress,8888);
            serverSocket.bind(inetSocketAddress);
            System.out.println("server begin");
            Socket socket = serverSocket.accept();
            System.out.println("server end");
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
