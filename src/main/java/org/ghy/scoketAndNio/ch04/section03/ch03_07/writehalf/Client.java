package org.ghy.scoketAndNio.ch04.section03.ch03_07.writehalf;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8088);
            InputStream inputStream = socket.getInputStream();
            byte[] byteArray = new byte[1000];
            int readLength = inputStream.read(byteArray);
            while (readLength!=-1){
                System.out.println(new String(byteArray,0,readLength));
                readLength = inputStream.read(byteArray);
            }
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
