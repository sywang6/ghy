package org.ghy.scoketAndNio.ch06.ch02_01;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test1 {
    public static void main(String[] args) throws IOException {
        final AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress(8088));
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel ch, Void attachment) {
                try {
                    serverSocketChannel.accept(null,this);//继续下一次连接
                    System.out.println("public void completed ThreadName="+Thread.currentThread().getName());
                    ByteBuffer buffer = ByteBuffer.allocate(25);
                    Future<Integer> readFuture = ch.read(buffer);
                    System.out.println("public void read end ThreadName="+Thread.currentThread().getName());
                    System.out.println(new String(buffer.array(),0,readFuture.get()));
                    ch.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("public void failed");
            }
        });
        while (true){

        }
    }
}
