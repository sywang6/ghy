package org.ghy.scoketAndNio.ch05.ch09_04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

//通过selectionKey获取Selector
public class Test4 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);
            Selector selector1 = Selector.open();
            SelectionKey selectionKey = serverSocketChannel.register(selector1,SelectionKey.OP_ACCEPT);
            Selector selector2 = selectionKey.selector();
            System.out.println(selector1+" "+selector1.hashCode());
            System.out.println(selector2+" "+selector2.hashCode());
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
