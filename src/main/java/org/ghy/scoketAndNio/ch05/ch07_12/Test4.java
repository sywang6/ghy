package org.ghy.scoketAndNio.ch05.ch07_12;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketOption;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

//获得支持的SocketOption列表(对应Socket和ServerSocket的一些配置项)
public class Test4 {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Socket socket  = new Socket("localhost",8088);
                    socket.close();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        try {
            t.start();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8088));
            SocketChannel socketChannel = serverSocketChannel.accept();
            //获得支持的SocketOption列表
            Set<SocketOption<?>> set1 = serverSocketChannel.supportedOptions();
            Set<SocketOption<?>> set2 = socketChannel.supportedOptions();
            set1.stream().forEach(e->{
                System.out.println(e.name()+" "+e.getClass().getName());
            });
            System.out.println();
            System.out.println();
            System.out.println();
            set2.stream().forEach(e->{
                System.out.println(e.name()+" "+e.getClass().getName());
            });
            socketChannel.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
