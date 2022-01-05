package org.ghy.scoketAndNio.ch05.ch07_02;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;

public class Test1_Server2 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            ServerSocket serverSocket = serverSocketChannel.socket();
            //已使用serverSocketChannel进行绑定操作,
            //那么就不再使用serverSocket进行bind()绑定
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
            inputStreamReader.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
