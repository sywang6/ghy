package org.ghy.scoketAndNio.ch05.ch09_02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test2_2 {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey = socketChannel.register(selector,SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("localhost",8088));
            int keyCount = selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeySet.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //是否可连接
                if(key.isConnectable()){
                    //等待连接完成
                    while (!socketChannel.finishConnect()){
                        System.out.println("!socketChannel.finishConnect()-----");
                    }
                    System.out.println("client isConnectable()");
                    SocketChannel channel = (SocketChannel)key.channel();
                    byte[] writeData = "我是来自客户端,你好,服务器! ".getBytes();
                    ByteBuffer buffer = ByteBuffer.wrap(writeData);
                    channel.write(buffer);
                    channel.close();
                }
            }
            System.out.println("client end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}













