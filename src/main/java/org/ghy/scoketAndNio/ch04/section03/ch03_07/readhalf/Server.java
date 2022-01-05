package org.ghy.scoketAndNio.ch04.section03.ch03_07.readhalf;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            System.out.println("A="+inputStream.available());
            byte[] byteArray = new byte[2];
            int readLength = inputStream.read(byteArray);
            System.out.println("server取得的数据:"+new String(byteArray,0,readLength));
            //屏蔽InputStream,到达流的结尾
            socket.shutdownInput();
            System.out.println("B="+inputStream.available());//静默丢弃其他数据
            readLength = inputStream.read(byteArray);
            System.out.println("readLength="+readLength);
            //再次调用getInputStream方法出现异常
            socket.getInputStream();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
