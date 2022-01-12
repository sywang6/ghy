package org.ghy.scoketAndNio.ch05.ch09_03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test3_2 {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey = socketChannel.register(selector,SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("localhost",8088));
            boolean isRun = true;
            while (isRun == true){
            int keyCount = selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeySet.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                //是否可用连接
                if(key.isConnectable()){
                    System.out.println("client isConnectale()");
                    if(socketChannel.isConnectionPending()){
                        while (!socketChannel.finishConnect()){
                        }
                        //注册感兴趣的事件
                        socketChannel.register(selector,SelectionKey.OP_WRITE);
                    }
                }
                if(key.isWritable()){
                    System.out.println("client isWriteable()");
                    byte[] writeData = "我来自客户端,你好,服务器! ".getBytes();
                    ByteBuffer buffer = ByteBuffer.wrap(writeData);
                    socketChannel.write(buffer);
                    socketChannel.close();
                }
            }
            }
            System.out.println("client end!");
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }
}













