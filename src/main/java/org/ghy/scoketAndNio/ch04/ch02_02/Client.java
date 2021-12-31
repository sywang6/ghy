package org.ghy.scoketAndNio.ch04.ch02_02;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("connect"+i+" begin "+System.currentTimeMillis());
                new Socket("localhost",8088);
                System.out.println("connect"+i+" end "+System.currentTimeMillis());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
