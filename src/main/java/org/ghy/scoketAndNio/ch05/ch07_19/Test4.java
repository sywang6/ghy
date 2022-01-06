package org.ghy.scoketAndNio.ch05.ch07_19;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Test4 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            SocketChannel socketChannel = SocketChannel.open();
            int value1 = serverSocketChannel.validOps();
            int value2 = socketChannel.validOps();
            System.out.println("value1="+value1);
            System.out.println("value2="+value2);
            //ServerSocketChannel支持OP_ACCEPT
            System.out.println(SelectionKey.OP_ACCEPT & ~serverSocketChannel.validOps());
            System.out.println(SelectionKey.OP_CONNECT & ~serverSocketChannel.validOps());
            System.out.println(SelectionKey.OP_READ & ~serverSocketChannel.validOps());
            System.out.println(SelectionKey.OP_WRITE & ~serverSocketChannel.validOps());
            System.out.println();
            //SocketChannel支持OP_CONNECT,OP_READ,OP_WRITE
            System.out.println(SelectionKey.OP_ACCEPT & ~socketChannel.validOps());
            System.out.println(SelectionKey.OP_CONNECT & ~socketChannel.validOps());
            System.out.println(SelectionKey.OP_READ & ~socketChannel.validOps());
            System.out.println(SelectionKey.OP_WRITE & ~socketChannel.validOps());
            socketChannel.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
