package org.ghy.scoketAndNio.ch04.section03.ch03_11.eg3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//Linger用于定义socket关闭时的行为
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            System.out.println("A socket.getSolinger()="+socket.getSoLinger());
            //Socket的SoLinger配置项默认为false
            //socket.setSoLinger(false,123123);
            System.out.println("B socket.getSolinger()="+socket.getSoLinger());
            OutputStream outputStream = socket.getOutputStream();
            for (int i = 0; i < 10; i++) {
                outputStream.write("123456789012345678901234567890123456789012345678901234567 8901234567890123456789012345678901234567890"
                .getBytes());
            }
            outputStream.write("end!".getBytes());
            System.out.println("socket close before="+System.currentTimeMillis());
            outputStream.close();
            socket.close();
            System.out.println("socket close after="+System.currentTimeMillis());
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
