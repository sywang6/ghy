package org.ghy.scoketAndNio.ch04.section01.ch01_08;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("F:\\var\\test.jpg"));
            byte[] byteArray = new byte[2048];
            Socket socket = new Socket("localhost",8088);
            OutputStream outputStream = socket.getOutputStream();
            int readLength = fileInputStream.read(byteArray);
            while (readLength!=-1){
                outputStream.write(byteArray,0,readLength);
                readLength = fileInputStream.read(byteArray);
            }
            outputStream.close();
            fileInputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
