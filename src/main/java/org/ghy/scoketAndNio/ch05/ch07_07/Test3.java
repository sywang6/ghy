package org.ghy.scoketAndNio.ch05.ch07_07;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Test3 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            ServerSocket serverSocket = serverSocketChannel.socket();
            serverSocket.bind(new InetSocketAddress("localhost",8888));
            //判断通道是否已经注册到任何选择器(可以重复注册,打开下面的注释部分的代码就可以了).
            //对SelectionKey执行取消操作和通道进行注销之间有延迟,因此在已取消某个通道的所有SelectionKey后,该通道可能在一定时间内还会保持已注册状态.
            // 关闭通道后,该通道可能在一定时间内还会保持已注册状态(如何验证呢?)
            System.out.println("A isRegistered="+serverSocketChannel.isRegistered());
            Selector selector = Selector.open();
            SelectionKey key = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println("B isRegistered="+serverSocketChannel.isRegistered());

            /*System.out.println("C isRegistered="+serverSocketChannel.isRegistered());
            Selector selector2 = Selector.open();
            SelectionKey key2 = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            System.out.println("D isRegistered="+serverSocketChannel.isRegistered());*/

            serverSocket.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
