package org.ghy.scoketAndNio.ch05.ch07_22;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest4_1 {
    public static void main(String[] args) {
        try {
            long beginTime = 0;
            long endTime = 0;
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            boolean connectResult = socketChannel.connect(new InetSocketAddress("localhost",8088));
            if(connectResult == false){
                System.out.println("connectResult == false");
                //非阻塞模式,直接启动client,判断是否连接上,最终抛出异常
                while (!socketChannel.finishConnect()){
                    System.out.println("一直尝试连接");
                }
            }
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
