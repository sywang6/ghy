package org.ghy.scoketAndNio.ch04.section03.ch03_13;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("server A getOOBInline="+socket.getOOBInline());
            //接收紧急数据包
            socket.setOOBInline(true);
            System.out.println("server B getOOBInline="+socket.getOOBInline());
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char[] charArray = new char[1024];
            int readLength = inputStreamReader.read(charArray);
            while (readLength != -1){
                String newString = new String(charArray,0,readLength);
                System.out.print(newString);
                readLength = inputStreamReader.read(charArray);
            }
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
