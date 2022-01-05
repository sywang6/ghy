package org.ghy.scoketAndNio.ch04.section03.ch03_09;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("172.16.16.148",8888);
            socket.setTcpNoDelay(false);
            InputStream inputStream = socket.getInputStream();
            long beginTime = System.currentTimeMillis();
            byte[] byteArray = new byte[1];
            int readLangth = inputStream.read(byteArray);
            while (readLangth != -1){
                String newString = new String(byteArray,0,readLangth);
                System.out.print(newString);
                readLangth = inputStream.read(byteArray);
            }
            System.out.println();
            long ensTime = System.currentTimeMillis();
            System.out.println(ensTime-beginTime);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
