package org.ghy.scoketAndNio.ch05.ch07_24;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test7 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] byteArray = new byte[1024];
            int readLength = inputStream.read(byteArray);
            while (readLength != -1){
                System.out.println(new String(byteArray,0,readLength));
                readLength = inputStream.read(byteArray);
            }
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
