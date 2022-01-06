package org.ghy.scoketAndNio.ch05.ch07_18;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

//不同的通道注册带相同的选择器,返回SelectionKey不是同一个对象
public class Test9_1 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
            ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
            serverSocketChannel1.configureBlocking(false);
            serverSocketChannel2.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey key1 = serverSocketChannel1.register(selector,SelectionKey.OP_ACCEPT);
            SelectionKey key2 = serverSocketChannel2.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println(key1);
            System.out.println(key2);
            serverSocketChannel1.close();
            serverSocketChannel2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
