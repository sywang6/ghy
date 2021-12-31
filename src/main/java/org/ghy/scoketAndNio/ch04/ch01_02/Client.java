package org.ghy.scoketAndNio.ch04.ch01_02;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            System.out.println("socket begin "+System.currentTimeMillis());
            Socket socket = new Socket("localhost",8088);
            System.out.println("socket end "+System.currentTimeMillis());
            Thread.sleep(Integer.MAX_VALUE);
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
