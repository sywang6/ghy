package org.ghy.scoketAndNio.ch05.ch07_01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8888);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("123456".getBytes());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
