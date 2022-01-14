package org.ghy.scoketAndNio.ch06.ch02_02;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

//客户端可以用ch02_01的Test2和Test3测试
public class Test4 {
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress(8088));
        System.out.println("A "+System.currentTimeMillis());
        //非阻塞
        Future<AsynchronousSocketChannel> socketChannelFuture = serverSocketChannel.accept();
        System.out.println("B "+System.currentTimeMillis());
        //阻塞
        AsynchronousSocketChannel socketChannel = socketChannelFuture.get();
        System.out.println("C "+System.currentTimeMillis());
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        System.out.println("D "+System.currentTimeMillis());
        Future<Integer> readFuture = socketChannel.read(byteBuffer);
        System.out.println("E "+System.currentTimeMillis());
        System.out.println(new String(byteBuffer.array(),0,readFuture.get()));
        System.out.println("F "+System.currentTimeMillis());
        Thread.sleep(400000);
    }
}
