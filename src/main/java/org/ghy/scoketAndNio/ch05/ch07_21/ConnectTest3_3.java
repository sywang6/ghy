package org.ghy.scoketAndNio.ch05.ch07_21;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class ConnectTest3_3 {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            //通道上是否正在进行连接操作
            System.out.println(socketChannel.isConnectionPending());
            //阻塞模式,ip地址存在
            socketChannel.connect(new InetSocketAddress("localhost",8088));
            System.out.println(socketChannel.isConnectionPending());
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("catch"+socketChannel.isConnectionPending());
        }
    }
}
