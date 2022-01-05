package org.ghy.scoketAndNio.ch04.section02.ch02_06;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//绑定到指定的Socket地址并设置backlog数量
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            //windows系统backlog的最大值是200
            serverSocket.bind(new InetSocketAddress(8888),5000);
            Thread.sleep(20000);
            for (int i = 0; i < 5000; i++) {
                System.out.println("server accept begin "+(i+1));
                Socket socket = serverSocket.accept();
                System.out.println("server accept end "+(i+1));
                socket.close();
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
