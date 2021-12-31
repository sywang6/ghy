package org.ghy.scoketAndNio.ch04.ch02_02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //backlog积压队列的大小,这个参数的控制最终由操作系统实现,默认值是50
            ServerSocket serverSocket = new ServerSocket(8088,3);
            Thread.sleep(10000);
            Socket[] sockets = new Socket[10];
            for (int i = 0; i < sockets.length; i++) {
                System.out.println("accept"+i+" begin "+System.currentTimeMillis());
                sockets[i] = serverSocket.accept();
                System.out.println("accept"+i+" end "+System.currentTimeMillis());
            }
            for (int i = 0; i < sockets.length; i++) {
                sockets[i].close();
            }
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
