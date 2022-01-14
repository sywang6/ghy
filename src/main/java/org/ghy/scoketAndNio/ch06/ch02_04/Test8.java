package org.ghy.scoketAndNio.ch06.ch02_04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Test8 {
    public static void main(String[] args) throws InterruptedException, IOException {
        final AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8088),null,new CompletionHandler<Void,Void>(){

            //连接完成后
            @Override
            public void completed(Void result, Void attachment) {
                try {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(Integer.MAX_VALUE/100);
                    for (int i = 0; i < Integer.MAX_VALUE / 100 - 3; i++) {
                        byteBuffer.put("1".getBytes());
                    }
                    byteBuffer.put("end".getBytes());
                    byteBuffer.flip();
                    int writeSum = 0;
                    while (writeSum < byteBuffer.limit()){
                        Future<Integer> writeFuture = socketChannel.write(byteBuffer);
                        Integer writeLength = writeFuture.get();
                        writeSum = writeSum+writeLength;
                    }
                    socketChannel.close();
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
                System.out.println("read public void failed(Throwable exc,Void attachment)");
                System.out.println("exc getMessage()="+exc.getClass().getName());
            }
        });
        Thread.sleep(10000);
    }
}
