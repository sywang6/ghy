package org.ghy.scoketAndNio.ch04.section01.ch01_03;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("socket begin "+System.currentTimeMillis());
            Socket socket = new Socket("localhost",8080);
            System.out.println("socket end "+System.currentTimeMillis());
            Thread.sleep(3000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是外星人".getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
