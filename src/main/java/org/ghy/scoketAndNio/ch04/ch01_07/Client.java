package org.ghy.scoketAndNio.ch04.ch01_07;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8088);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是中国人".getBytes());
            outputStream.close();
            Thread.sleep(Integer.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
