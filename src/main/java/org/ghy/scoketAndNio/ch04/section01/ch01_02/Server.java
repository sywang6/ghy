package org.ghy.scoketAndNio.ch04.section01.ch01_02;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {
            byte[] byteArray = new byte[1024];
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("accept begin "+System.currentTimeMillis());
            Socket socket = serverSocket.accept();
            System.out.println("accept end "+System.currentTimeMillis());

            InputStream inputStream = socket.getInputStream();
            System.out.println("read begin "+System.currentTimeMillis());
            //read方法也具有阻塞的特性,获取从对方发送过来的数据
            int readLength = inputStream.read(byteArray);
            System.out.println("read end "+System.currentTimeMillis());
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
