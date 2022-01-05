package org.ghy.scoketAndNio.ch05.ch07_06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test2 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
           serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress("localhost",8888));
            Selector selector = Selector.open();
            //通道必须设置为非阻塞的,否则注册到选择器上会报IllegalBlockingModeException异常
            //执行注册操作与获得SelectionKey对象
            SelectionKey key = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println("selector="+selector);
            System.out.println("key="+key);
            serverSocket.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
