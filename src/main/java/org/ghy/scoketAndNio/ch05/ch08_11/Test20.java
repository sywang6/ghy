package org.ghy.scoketAndNio.ch05.ch08_11;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test20 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
            serverSocketChannel1.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel1.configureBlocking(false);

            ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
            serverSocketChannel2.bind(new InetSocketAddress("localhost",9999));
            serverSocketChannel2.configureBlocking(false);

            ServerSocketChannel serverSocketChannel3 = ServerSocketChannel.open();
            serverSocketChannel3.bind(new InetSocketAddress("localhost",7777));
            serverSocketChannel3.configureBlocking(false);

            Selector selector = Selector.open();

            SelectionKey selectionKey1 = serverSocketChannel1.register(selector,SelectionKey.OP_ACCEPT);
            SelectionKey selectionKey2 = serverSocketChannel2.register(selector,SelectionKey.OP_ACCEPT);
            SelectionKey selectionKey3 = serverSocketChannel3.register(selector,SelectionKey.OP_ACCEPT);

            System.out.println(selectionKey1.hashCode());
            System.out.println(selectionKey2.hashCode());
            System.out.println(selectionKey3.hashCode());
            System.out.println();
            //获得Selector的所有键集
            Set<SelectionKey> keySet = selector.keys();
            Iterator<SelectionKey> iterator = keySet.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                System.out.println(key.hashCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
