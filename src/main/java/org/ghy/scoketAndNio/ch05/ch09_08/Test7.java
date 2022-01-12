package org.ghy.scoketAndNio.ch05.ch09_08;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test7 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            //判断此键是否有效,在被取消,其通道已关闭或者其选择器已经关闭之前保持有效
            System.out.println(selectionKey.isValid());
            selectionKey.cancel();
            System.out.println(selectionKey.isValid());
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
