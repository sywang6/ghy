package org.ghy.scoketAndNio.ch06.ch02_01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Test2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8088);
            OutputStream outputStream = socket.getOutputStream();
            //Thread.sleep(20000);
            outputStream.write("我来自客户端1".getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}
