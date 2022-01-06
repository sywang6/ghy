package org.ghy.scoketAndNio.ch05.ch08_07;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Test13 {
    public static void main(String[] args) {
        try {
            Socket socket =  new Socket("localhost",8888);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是中国人,我来自客户端!".getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
