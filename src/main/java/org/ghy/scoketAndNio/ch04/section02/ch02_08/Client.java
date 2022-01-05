package org.ghy.scoketAndNio.ch04.section02.ch02_08;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("client begin");
            Socket socket = new Socket("localhost",8888);
            System.out.println("client end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
