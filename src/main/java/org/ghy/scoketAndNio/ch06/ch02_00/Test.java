package org.ghy.scoketAndNio.ch06.ch02_00;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class Test {
    public static void main(String[] args) throws IOException {
        final AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open().bind(
           new InetSocketAddress(8088)
        );
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Void attachment) {
                serverSocketChannel.accept(null,this);
                //处理连接
            }

            @Override
            public void failed(Throwable exc, Void attachment) {

            }
        });
    }
}
