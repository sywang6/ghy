package org.ghy.scoketAndNio.ch04.ch02_13;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            System.out.println("A server serverSocket.getReceiveBufferSize()="+serverSocket.getReceiveBufferSize());
            //调整接收缓冲区的大小,服务端最好在bind之前设置,客户端最好在connect之前设置
            serverSocket.setReceiveBufferSize(75536);
            System.out.println("B server serverSocket.getReceiveBufferSize()="+serverSocket.getReceiveBufferSize());
            serverSocket.bind(new InetSocketAddress("localhost",8088));

            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            char[] charArray = new char[1024];
            int readLength = inputStreamReader.read(charArray);
            while (readLength!=-1){
                String newString = new String(charArray,0,readLength);
                System.out.println(newString);
                readLength = inputStreamReader.read(charArray);
            }
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
