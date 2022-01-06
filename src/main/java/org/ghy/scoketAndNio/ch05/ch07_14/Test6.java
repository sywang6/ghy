package org.ghy.scoketAndNio.ch05.ch07_14;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class Test6 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            //获得SocketAddress对象
            InetSocketAddress address = (InetSocketAddress) serverSocketChannel.getLocalAddress();
            System.out.println(address.getHostString());
            System.out.println(address.getPort());
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
