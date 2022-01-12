package org.ghy.scoketAndNio.ch05.ch08_15;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

//调用Selector.close()方法删除全部键并且通道注销
public class Test8 {
    private static Selector selector;
    public static void main(String[] args) {
        try {
            //2秒之后关闭选择器
            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        selector.close();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            int keyCount = selector.select();
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeySet.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                    Socket socket = channel.socket().accept();
                    socket.close();
                }
                iterator.remove();
            }
            serverSocketChannel.close();
            System.out.println("main end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
