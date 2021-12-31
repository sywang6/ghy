package org.ghy.scoketAndNio.ch04.ch01_05;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("client连接准备="+System.currentTimeMillis());
            Socket socket = new Socket("localhost",8088);
            System.out.println("clent连接结束="+System.currentTimeMillis());
            Thread.sleep(2000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是高洪岩1".getBytes());
            Thread.sleep(3000);
            outputStream.write("我是高洪岩2".getBytes());
            Thread.sleep(3000);
            outputStream.write("我是高洪岩3".getBytes());
            Thread.sleep(3000);
            outputStream.write("我是高洪岩4".getBytes());
            Thread.sleep(3000);
            outputStream.write("我是高洪岩5".getBytes());
            System.out.println("client close begin="+System.currentTimeMillis());
            outputStream.close();
            socket.close();
            System.out.println("client close end="+System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
