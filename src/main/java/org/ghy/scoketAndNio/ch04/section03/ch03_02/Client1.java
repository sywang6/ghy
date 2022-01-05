package org.ghy.scoketAndNio.ch04.section03.ch03_02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) {
        long beginTime = 0;
        try {
            Socket socket = new Socket();
            socket.bind(new InetSocketAddress("172.16.16.148",7777));
            beginTime = System.currentTimeMillis();
            //6秒之后连接超时,Socket绑定了特定端口
            socket.connect(new InetSocketAddress("1.1.1.1",8888),6000);
            socket.close();
            System.out.println("clinet end!");
        } catch (IOException e) {
            long endTime = System.currentTimeMillis();
            System.out.println(endTime-beginTime);
            e.printStackTrace();
        }
    }
}
