package org.ghy.scoketAndNio.ch04.ch02_03;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 100; i++) {
                Socket socket = new Socket("localhost",8088);
                System.out.println("client发起连接次数:"+(i+1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
