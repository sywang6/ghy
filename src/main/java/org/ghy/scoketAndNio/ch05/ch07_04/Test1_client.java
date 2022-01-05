package org.ghy.scoketAndNio.ch05.ch07_04;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class Test1_client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8888);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是发送的数据Client".getBytes());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
