package org.ghy.scoketAndNio.ch05.ch07_03;

import java.io.IOException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Test1_Server3_Client {
    public static void main(String[] args) {
        try {
            List<Socket> socketList = new LinkedList<>();
            for (int i = 0; i < 100; i++) {
                socketList.add(new Socket("localhost",8888));
                System.out.println("客户端连接个数为:"+(i+1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
