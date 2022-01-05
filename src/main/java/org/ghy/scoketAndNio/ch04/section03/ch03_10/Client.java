package org.ghy.scoketAndNio.ch04.section03.ch03_10;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            System.out.println("A client socket.getSendBufferSize()="+socket.getSendBufferSize());
            //发送缓存区设置为1个字节,发送完成需要235136ms
            //socket.setSendBufferSize(1);
            //发送缓存区设置为1024*1024个字节,发送完成需要196419ms
            socket.setSendBufferSize(1024*1024);
            System.out.println("B client socket.getSendBufferSize()="+socket.getSendBufferSize());
            socket.connect(new InetSocketAddress("localhost",8888));
            OutputStream outputStream = socket.getOutputStream();
            for (int i = 0; i < 5000000; i++) {
                outputStream.write("123456789123456789123456789123456789123456 789".getBytes());
                System.out.println(i+1);
            }
            outputStream.write("end!".getBytes());
            outputStream.close();
            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
