package org.ghy.scoketAndNio.ch04.section01.ch01_03;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//客户端向服务端传递字符串
public class Server {
    public static void main(String[] args) {
        try {
            char[] charArray = new char[3];
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("accpt begin"+System.currentTimeMillis());
            Socket socket = serverSocket.accept();
            System.out.println("accpt end"+System.currentTimeMillis());
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            System.out.println("read begin "+System.currentTimeMillis());
            int readLength = inputStreamReader.read(charArray);
            while (readLength!=-1){
                String newString = new String(charArray,0,readLength);
                System.out.println(newString);
                readLength = inputStreamReader.read(charArray);
            }
            System.out.println("read end "+System.currentTimeMillis());
            inputStreamReader.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
