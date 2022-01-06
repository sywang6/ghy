package org.ghy.scoketAndNio.ch05.ch07_20;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest1 {
    public static void main(String[] args) {
        long beginTime = 0;
        long endTime = 0;
        boolean connectResult = false;
        try {
            SocketChannel socketChannel = SocketChannel.open();
            beginTime = System.currentTimeMillis();
            //SocketChannel处于阻塞模式,在发生错误或连接到目标之前,connect()方法一直是阻塞的
            connectResult = socketChannel.connect(new InetSocketAddress("localhost",8088));
            endTime = System.currentTimeMillis();
            System.out.println("正常连接耗时: "+(endTime-beginTime)+" connectResult"+connectResult);
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
            endTime = System.currentTimeMillis();
            System.out.println("异常连接耗时: "+(endTime-beginTime)+" connectResult"+connectResult);
        }

    }
}
