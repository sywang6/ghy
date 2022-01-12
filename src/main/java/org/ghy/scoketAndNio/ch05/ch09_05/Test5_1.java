package org.ghy.scoketAndNio.ch05.ch09_05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test5_1 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey1 = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            SocketChannel socketChannel = null;
            boolean isRun = true;
            while (isRun == true){
                selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()){
                   SelectionKey key = iterator.next();
                   if(key.isAcceptable()){
                        ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                       System.out.println("server isAcceptable()");
                       socketChannel = channel.accept();
                       socketChannel.configureBlocking(false);
                       socketChannel.register(selector,SelectionKey.OP_READ);
                   }
                   if(key.isReadable()){
                       System.out.println("server isReadable()");
                       ByteBuffer buffer = ByteBuffer.allocate(1000);
                       int readLength = socketChannel.read(buffer);
                       while (readLength != -1){
                           String newString = new String(buffer.array(),0,readLength);
                           System.out.println(newString);
                           readLength = socketChannel.read(buffer);
                       }
                       socketChannel.close();
                   }
                   iterator.remove();
                }
            }
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}








