package org.ghy.scoketAndNio.ch05.ch07_20;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest2 {
    public static void main(String[] args) {
        long beginTime = 0;
        long endTime = 0;
        boolean connectResult = false;
        try {
            SocketChannel socketChannel = SocketChannel.open();
            //配置非阻塞模式
            socketChannel.configureBlocking(false);
            beginTime = System.currentTimeMillis();
            //SocketChannel处于非阻塞模式,connect方法立即返回.一般返回值为false,表示连接操作还未完成,需要随后发起检查
            //Returns:
            //true if a connection was established, false if this channel is in non-blocking mode and the connection operation is in progress
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
