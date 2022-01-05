package org.ghy.scoketAndNio.ch04.section03.ch03_12;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("setSoTimeout before "+socket.getSoTimeout());
            //进入read阻塞前设置超时值,read方法阻塞超过该时间,抛出Read timed out异常
            socket.setSoTimeout(5000);
            System.out.println("setSoTimeout after "+socket.getSoTimeout());
            InputStream inputStream = socket.getInputStream();
            byte[] byteArray = new byte[1024];
            System.out.println("read begin__:"+System.currentTimeMillis());
            int readLength = inputStream.read(byteArray);
            System.out.println("read end:"+System.currentTimeMillis());
        } catch (SocketTimeoutException e){
            System.out.println("time out:"+System.currentTimeMillis());
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
