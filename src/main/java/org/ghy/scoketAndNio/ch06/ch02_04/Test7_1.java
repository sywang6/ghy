package org.ghy.scoketAndNio.ch06.ch02_04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

public class Test7_1 {
    public static void main(String[] args) throws IOException {
        final AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open()
                .bind(new InetSocketAddress(8088));
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel ch, Void attachment) {
                //接收下一个连接请求
                serverSocketChannel.accept(null,this);
                ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.MAX_VALUE/100);
                //处理当前连接
                ch.read(byteBuffer, 15, TimeUnit.SECONDS, null, new CompletionHandler<Integer, Void>() {
                    //读取完成后的回调
                    @Override
                    public void completed(Integer result, Void attachment) {
                        if(result == -1){
                            System.out.println("客户端没有传输数据就执行close了,到stream end");
                        }
                        if(result == byteBuffer.limit()){
                            System.out.println("服务端获得客户端完整数据");
                        }
                        try {
                            ch.close();
                            System.out.println("服务端close");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Void attachment) {
                        System.out.println("read public void failed(Throwable exc,Void attachment)");
                        System.out.println("exc getMessage()="+exc.getClass().getName());
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("accept public void failed");
            }
        });
        while (true){

        }
    }
}
