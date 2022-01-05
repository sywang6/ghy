package org.ghy.scoketAndNio.ch04.section01.ch01_08;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

//使用socket传递图片
public class Server {
    public static void main(String[] args) {
        try {
            byte[] byteArray = new byte[2048];
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            int readLength = inputStream.read(byteArray);
            FileOutputStream fileOutputStream = new FileOutputStream(new File("F:\\var\\test-new.jpg"));
            while (readLength != -1){
                fileOutputStream.write(byteArray,0,readLength);
                readLength = inputStream.read(byteArray);
            }
            fileOutputStream.close();
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
