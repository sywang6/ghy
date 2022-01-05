package org.ghy.scoketAndNio.ch04.section03.ch03_07.writehalf;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            OutputStream out = socket.getOutputStream();
            out.write("123".getBytes());
            socket.shutdownOutput();//关闭输出流
            //socket.getOutputStream();//出现异常
            out.write("456".getBytes());//出现异常
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
