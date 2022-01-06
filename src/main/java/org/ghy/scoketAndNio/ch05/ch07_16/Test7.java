package org.ghy.scoketAndNio.ch05.ch07_16;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test7 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            //
            SelectionKey selectionKey1 = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println("A="+selectionKey1+" "+selectionKey1.hashCode());
            //获得通道注册到指定选择器的的SelectionKey
            SelectionKey selectionKey2 = serverSocketChannel.keyFor(selector);
            System.out.println("B="+selectionKey2+" "+selectionKey2.hashCode());
            //selectionKey1与selectionKey2的hashcode相等
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
