package org.ghy.scoketAndNio.ch04.section01.ch01_05;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//连接没关闭之前,允许多次调用write()方法进行写入操作
public class Server {
    public static void main(String[] args) {
        try {
            char[] charBuffer = new char[15];
            ServerSocket serverSocket = new ServerSocket(8088);
            System.out.println("server阻塞开始="+System.currentTimeMillis());
            Socket socket = serverSocket.accept();
            System.out.println("server阻塞结束="+System.currentTimeMillis());
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            System.out.println("serverB begin "+System.currentTimeMillis());
            int readLength = inputStreamReader.read(charBuffer);
            System.out.println("serverB end "+System.currentTimeMillis());
            while (readLength != -1){
                System.out.println(new String(charBuffer,0,readLength) + " while "+System.currentTimeMillis());
                readLength = inputStreamReader.read(charBuffer);
            }
            inputStream.close();
            socket.close();
            serverSocket.close();
            System.out.println("server端运行结束="+System.currentTimeMillis());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
