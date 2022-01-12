package org.ghy.scoketAndNio.ch05.ch09_01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test1_2 {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_CONNECT);
            boolean isRun = true;
            socketChannel.connect(new InetSocketAddress("localhost",8888));
            while (isRun == true){
                int keyCount = selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    //测试此键的通道是否可以进行套接字连接操作
                    if(key.isConnectable()){
                        System.out.println("client isConnectable()");
                        while (!socketChannel.finishConnect()){
                            System.out.println("!socketChannel.finishConnect");
                        }
                        SocketChannel channel = (SocketChannel)key.channel();
                        channel.close();
                    }
                    iterator.remove();
                }
            }
            socketChannel.close();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
