package org.ghy.scoketAndNio.ch04.ch02_13;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            System.out.println("begin "+socket.getReceiveBufferSize());
            socket.connect(new InetSocketAddress("localhost",8088));
            System.out.println(" end "+socket.getReceiveBufferSize());
            OutputStream outputStream = socket.getOutputStream();
            for (int i = 0; i < 100; i++) {
                outputStream.write(("l23456789123456789123456789123456789123456789123" +
                        "456789123456789123456789123456789123456789123456789" +
                        "123456789123456789123456789123456789123456789123456" +
                        "789123456789123456789123456789123456789123456789123" +
                        "456789123456789123456789123456789123456789123456789" +
                        "123456789123456789123456789123456789123456789123456" +
                        "789123456789123456789123456789123456789123456789123" +
                        "456789123456789123456789123456789123456789123456789" +
                        "123456789123456789123456789123456789123456789123456" +
                        "789123456789123456789123456789123456789123456789123" +
                        "456789123456789123456789123456789123456789123456789" +
                        "123456789123456789123456789123456789123456789123456" +
                        "789123456789123456789").getBytes());
            }
            outputStream.write("end!".getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
