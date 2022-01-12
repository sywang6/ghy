package org.ghy.scoketAndNio.ch05.ch09_09;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test8_2 {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey1 = socketChannel.register(selector,SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("localhost",8888));
            boolean isRun = true;
            while (isRun == true){
                int keyCount = selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isConnectable()){
                        System.out.println(  "server isConnectable() OP_ACCEPT result="+(SelectionKey.OP_ACCEPT & ~key.readyOps()) );
                        System.out.println(  "server isConnectable() OP_CONNECT result="+(SelectionKey.OP_CONNECT & ~key.readyOps()) );
                        System.out.println(  "server isConnectable() OP_OP_READ result="+(SelectionKey.OP_READ & ~key.readyOps()) );
                        System.out.println(  "server isConnectable() OP_OP_WRITE result="+(SelectionKey.OP_WRITE & ~key.readyOps()) );
                        if(socketChannel.isConnectionPending()){
                            while (!socketChannel.finishConnect()){
                                System.out.println("!socketChannel.finishConnect()----");
                            }
                            selectionKey1 = socketChannel.register(selector,SelectionKey.OP_WRITE,"我使用附件进行注册,我来自客户端,你好服务端! ");
                        }
                    }
                    if(key.isWritable()){
                        System.out.println(  "server isWritable() OP_ACCEPT result="+(SelectionKey.OP_ACCEPT & ~key.readyOps()) );
                        System.out.println(  "server isWritable() OP_CONNECT result="+(SelectionKey.OP_CONNECT & ~key.readyOps()) );
                        System.out.println(  "server isWritable() OP_OP_READ result="+(SelectionKey.OP_READ & ~key.readyOps()) );
                        System.out.println(  "server isWritable() OP_OP_WRITE result="+(SelectionKey.OP_WRITE & ~key.readyOps()) );
                        ByteBuffer buffer = ByteBuffer.wrap(((String)key.attachment()).getBytes());
                        socketChannel.write(buffer);
                        socketChannel.close();
                        key.cancel();
                    }
                }
            }
            System.out.println("client end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
