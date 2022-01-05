package org.ghy.scoketAndNio.ch05.ch07_03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.util.LinkedList;
import java.util.List;

public class Test1_Server3 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //绑定是设置积压队列的大小
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888),60);
            ServerSocket serverSocket = serverSocketChannel.socket();
            //sleep时间稍微长一点,否则积压队列可能到不了60
            Thread.sleep(15000);
            boolean isRun = true;
            List<Socket> socketList = new LinkedList<>();
            int i = 0;
            while (isRun ==true){
                socketList.add(serverSocket.accept());
                System.out.println("服务端连接个数为:"+(i+1));
                i++;
                //socket.close();
            }
            Thread.sleep(8000);
            serverSocket.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
