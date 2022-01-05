package org.ghy.scoketAndNio.ch04.section03.ch03_10;

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
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char[] charArray = new char[1024];
            int readLength = inputStreamReader.read(charArray);
            long beginTime = System.currentTimeMillis();
            while (readLength!=-1){
                String newString = new String(charArray,0,readLength);
                System.out.println(newString);
                readLength = inputStreamReader.read(charArray);
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime-beginTime);
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
