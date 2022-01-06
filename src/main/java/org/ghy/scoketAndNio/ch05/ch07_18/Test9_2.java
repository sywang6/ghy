package org.ghy.scoketAndNio.ch05.ch07_18;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

//不同的通道注册到不同的选择器,返回的SelectionKey不是同一个对象
public class Test9_2 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
            ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
            serverSocketChannel1.configureBlocking(false);
            serverSocketChannel2.configureBlocking(false);
            Selector selector1 = Selector.open();
            Selector selector2 = Selector.open();
            SelectionKey selectionKey1 =  serverSocketChannel1.register(selector1, SelectionKey.OP_ACCEPT);
            SelectionKey selectionKey2 =  serverSocketChannel2.register(selector2, SelectionKey.OP_ACCEPT);
            System.out.println(selectionKey1);
            System.out.println(selectionKey2);
            serverSocketChannel1.close();
            serverSocketChannel2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
