package org.ghy.scoketAndNio.ch04.ch01_11;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//wireshark抓包,分析tcp四次挥手过程
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("server阻塞开始="+System.currentTimeMillis());
             Socket socket =  serverSocket.accept();
            System.out.println("server阻塞结束="+System.currentTimeMillis());
            Thread.sleep(50);
            socket.close();
            serverSocket.close();
            Thread.sleep(2000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
