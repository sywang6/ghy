package org.ghy.scoketAndNio.ch05.ch07_10;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

public class Test2 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //判断通道是否打开
            System.out.println("A serverSocketChannel.isOpen()="+serverSocketChannel.isOpen());
            serverSocketChannel.close();
            System.out.println("B serverSocketChannel.isOpen()="+serverSocketChannel.isOpen());
            serverSocketChannel = ServerSocketChannel.open();
            System.out.println("B serverSocketChannel.isOpen()="+serverSocketChannel.isOpen());
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
