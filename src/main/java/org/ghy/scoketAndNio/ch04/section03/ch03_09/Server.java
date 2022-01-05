package org.ghy.scoketAndNio.ch04.section03.ch03_09;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            System.out.println("A="+socket.getTcpNoDelay());
            //Nagle算法开关,发送端的缓存,零碎的小包累积成大包在发送
            //NoDelay立即发送,不缓存数据,不启用Nagle算法.默认为false,也就是说尽量发送大包
            socket.setTcpNoDelay(true);
            System.out.println("B="+socket.getTcpNoDelay());
            OutputStream outputStream = socket.getOutputStream();
            for (int i = 0; i < 10; i++) {
                outputStream.write("1".getBytes());
            }
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
