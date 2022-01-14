package org.ghy.scoketAndNio.ch06.ch02_04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class Test9 {
    public static void main(String[] args) throws IOException, InterruptedException {
        final AsynchronousSocketChannel socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",8088),
        null,new CompletionHandler<Void,Void>(){
                    @Override
                    public void completed(Void result, Void attachment) {
                        try {
                            socketChannel.close();
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
        Thread.sleep(10000);
    }
}
