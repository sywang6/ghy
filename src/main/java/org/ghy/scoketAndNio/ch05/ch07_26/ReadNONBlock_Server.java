package org.ghy.scoketAndNio.ch05.ch07_26;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ReadNONBlock_Server {
    public static void main(String[] args) {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress("localhost",7077));
            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);
            selector.select();
            Set<SelectionKey> set = selector.selectedKeys();
            Iterator<SelectionKey> iterator = set.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                ByteBuffer byteBuffer = ByteBuffer.allocate(100);
                System.out.println("begin "+System.currentTimeMillis());
                //read方法也是非阻塞的,即使对端没有发送任何数据,read方法也会理解返回,不读取任何数据
                socketChannel.read(byteBuffer);
                System.out.println(" end "+System.currentTimeMillis()+" byteBuffer.position()="+byteBuffer.position());
            }
        channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
