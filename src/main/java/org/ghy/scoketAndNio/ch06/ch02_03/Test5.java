package org.ghy.scoketAndNio.ch06.ch02_03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

//客户端可以用ch02_01的Test2和Test3测试
public class Test5 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress(8088));
        Future<AsynchronousSocketChannel> socketChannelFuture =   serverSocketChannel.accept();
        AsynchronousSocketChannel socketChannel =  socketChannelFuture.get();
        ByteBuffer byteBuffer = ByteBuffer.allocate(20);
        //连续调用两次read方法导致异常,调用read方法之后要调用readFuture1.get方法,获得读取的字节数
        Future<Integer> readFuture1 =  socketChannel.read(byteBuffer);
        Future<Integer> readFuture2 = socketChannel.read(byteBuffer);
    }
}
