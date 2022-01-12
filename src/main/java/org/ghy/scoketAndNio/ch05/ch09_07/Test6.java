package org.ghy.scoketAndNio.ch05.ch09_07;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

//获取与设置此键的interset集合(感兴趣事件的集合)
public class Test6 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
            serverSocketChannel1.configureBlocking(false);

            SocketChannel socketChannel1 = SocketChannel.open();
            socketChannel1.configureBlocking(false);

            SocketChannel socketChannel2 = SocketChannel.open();
            socketChannel2.configureBlocking(false);

            Selector selector = Selector.open();
            SelectionKey key1 = serverSocketChannel1.register(selector,SelectionKey.OP_ACCEPT);

            SelectionKey key2 = socketChannel1.register(selector,SelectionKey.OP_CONNECT | SelectionKey.OP_READ);

            SelectionKey key3 = socketChannel2.register(selector,SelectionKey.OP_CONNECT
                    |SelectionKey.OP_READ|SelectionKey.OP_WRITE);
            System.out.println(~key1.interestOps() & SelectionKey.OP_ACCEPT);
            System.out.println(~key1.interestOps() & SelectionKey.OP_CONNECT);
            System.out.println(~key1.interestOps() & SelectionKey.OP_READ);
            System.out.println(~key1.interestOps() & SelectionKey.OP_WRITE);
            System.out.println();
            System.out.println(~key2.interestOps() & SelectionKey.OP_ACCEPT);
            System.out.println(~key2.interestOps() & SelectionKey.OP_CONNECT);
            System.out.println(~key2.interestOps() & SelectionKey.OP_READ);
            System.out.println(~key2.interestOps() & SelectionKey.OP_WRITE);
            System.out.println();
            System.out.println(~key3.interestOps() & SelectionKey.OP_ACCEPT);
            System.out.println(~key3.interestOps() & SelectionKey.OP_CONNECT);
            System.out.println(~key3.interestOps() & SelectionKey.OP_READ);
            System.out.println(~key3.interestOps() & SelectionKey.OP_WRITE);
            System.out.println();
            //重新定义感兴趣的事件,会覆盖已有的设置
            key3.interestOps(SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT);
            System.out.println(~key3.interestOps() & SelectionKey.OP_ACCEPT);
            System.out.println(~key3.interestOps() & SelectionKey.OP_CONNECT);
            System.out.println(~key3.interestOps() & SelectionKey.OP_READ);
            System.out.println(~key3.interestOps() & SelectionKey.OP_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
