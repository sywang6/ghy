package org.ghy.scoketAndNio.ch04.section01.ch01_13;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class BeginClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8088);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是中国人".getBytes());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
