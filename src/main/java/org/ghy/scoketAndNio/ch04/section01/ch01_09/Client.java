package org.ghy.scoketAndNio.ch04.section01.ch01_09;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("client连接准备="+System.currentTimeMillis());
            Socket socket = new Socket("localhost",8088);
            System.out.println("client连接结束="+System.currentTimeMillis());
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("111".getBytes());
            outputStream.write("11111".getBytes());
            outputStream.write("1111111111".getBytes());
            Thread.sleep(Integer.MAX_VALUE);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
