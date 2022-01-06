package org.ghy.scoketAndNio.ch05.ch07_18;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

//相同的通道重复注册相同的选择器,返回的Selectionkey是同一个对象
public class Test9_3 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey key1 = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            SelectionKey key2 = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println(key1);
            System.out.println(key2);
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
