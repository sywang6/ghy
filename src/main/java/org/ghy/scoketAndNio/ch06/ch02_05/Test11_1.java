package org.ghy.scoketAndNio.ch06.ch02_05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

public class Test11_1 {
    public static void main(String[] args) throws InterruptedException, IOException {
        final AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8088), null, new CompletionHandler<Void, Void>() {
            @Override
            public void completed(Void result, Void attachment) {
                ByteBuffer  byteBuffer = ByteBuffer.allocate(Integer.MAX_VALUE/100);
                for (int i = 0; i < Integer.MAX_VALUE/100-3; i++) {
                    byteBuffer.put("1".getBytes());
                }
                byteBuffer.put("end".getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer, 1, TimeUnit.SECONDS, null, new CompletionHandler<Integer, Void>() {
                    @Override
                    public void completed(Integer result, Void attachment) {
                        try {
                            socketChannel.close();
                            System.out.println("client close");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void failed(Throwable exc, Void attachment) {
                        System.out.println("connect public void failed(Throwable exc,Void attachment)");
                        System.out.println("exc getMessage()="+exc.getClass().getName());
                    }
                });
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("connect public void failed(Throwable exc,Void attachment)");
                System.out.println("exc getMessage()="+exc.getClass().getName());
            }
        });
        Thread.sleep(5000);
    }
}
