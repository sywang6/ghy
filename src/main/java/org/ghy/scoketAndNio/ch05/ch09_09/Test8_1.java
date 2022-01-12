package org.ghy.scoketAndNio.ch05.ch09_09;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test8_1 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            SocketChannel socketChannel = null;
            boolean isRun = true;
            while (isRun == true){
                selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        ServerSocketChannel channel =  (ServerSocketChannel)key.channel();
                        System.out.println(  "server isAcceptable() OP_ACCEPT result="+(SelectionKey.OP_ACCEPT & ~key.readyOps()) );
                        System.out.println(  "server isAcceptable() OP_CONNECT result="+(SelectionKey.OP_CONNECT & ~key.readyOps()) );
                        System.out.println(  "server isAcceptable() OP_OP_READ result="+(SelectionKey.OP_READ & ~key.readyOps()) );
                        System.out.println(  "server isAcceptable() OP_OP_WRITE result="+(SelectionKey.OP_WRITE & ~key.readyOps()) );
                        socketChannel = channel.accept();
                        socketChannel.configureBlocking(false);
                        //设置读为感兴趣事件
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }
                    if(key.isReadable()){
                        System.out.println(  "server isReadable() OP_ACCEPT result="+(SelectionKey.OP_ACCEPT & ~key.readyOps()) );
                        System.out.println(  "server isReadable() OP_CONNECT result="+(SelectionKey.OP_CONNECT & ~key.readyOps()) );
                        System.out.println(  "server isReadable() OP_OP_READ result="+(SelectionKey.OP_READ & ~key.readyOps()) );
                        System.out.println(  "server isReadable() OP_OP_WRITE result="+(SelectionKey.OP_WRITE & ~key.readyOps()) );
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
