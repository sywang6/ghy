package org.ghy.scoketAndNio.ch05.ch07_22;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ConnectTest4_2 {
    public static void main(String[] args) {
        try {
            long beginTime = 0;
            long endTime = 0;
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            boolean connectResult = socketChannel.connect(new InetSocketAddress("localhost",8088));
            Thread t = new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(50);
                        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                        serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
                        SocketChannel socketChannel1 = serverSocketChannel.accept();
                        Thread.sleep(100);
                        socketChannel.close();
                        serverSocketChannel.close();
                        System.out.println("sever end!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            if(connectResult == false){
                System.out.println("connectResult == false");
                //一段时间后正常连接上
                while (!socketChannel.finishConnect()){
                    System.out.println("一直在尝试连接");
                }
            }
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
