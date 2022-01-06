package org.ghy.scoketAndNio.ch05.ch07_18;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

//相同的通道可以注册到不同的选择器,返回的SelectionKey不是同一个对象
public class Test9 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);
            Selector selector1 = Selector.open();
            Selector selector2 = Selector.open();
            SelectionKey selectionKey1 = serverSocketChannel.register(selector1,SelectionKey.OP_ACCEPT);
            System.out.println("selectionKey1="+selectionKey1.hashCode());
            SelectionKey selectionKey2 = serverSocketChannel.register(selector2,SelectionKey.OP_ACCEPT);
            System.out.println("selectionKey2="+selectionKey2.hashCode());
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
