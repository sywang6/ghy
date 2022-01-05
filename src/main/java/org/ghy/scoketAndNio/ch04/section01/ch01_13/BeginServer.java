package org.ghy.scoketAndNio.ch04.section01.ch01_13;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//每连接一线程,未使用线程池版本
public class BeginServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            int runTag = 1;
            //死循环,能够一直接受连接
            while (runTag == 1){
                //接受一个连接
                Socket socket = serverSocket.accept();
                //创建一个线程处理这个连接
                BeginThread beginThread = new BeginThread(socket);
                beginThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
