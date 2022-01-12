package org.ghy.scoketAndNio.ch05.ch08_13;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test23 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);

            Selector selector = Selector.open();
            SelectionKey selectionKey1 = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun == true){
                System.out.println("while(isRun == true)"+System.currentTimeMillis());
                //非阻塞,如果没有已经就绪的事件也会立即返回
                int keyCount = selector.selectNow();
                System.out.println("while(isRun == true)"+System.currentTimeMillis());
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()){
                    System.out.println("进入while");
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                        Socket socket = channel.socket().accept();
                        socket.close();
                    }
                    iterator.remove();
                }
            }
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
