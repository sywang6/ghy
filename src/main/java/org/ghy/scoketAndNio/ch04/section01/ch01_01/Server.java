package org.ghy.scoketAndNio.ch04.section01.ch01_01;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8080);
            System.out.println("server阻塞开始="+System.currentTimeMillis());
            //ServerSocket的accept方法具有阻塞特性
            socket.accept();
            System.out.println("server阻塞结束="+System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
