package org.ghy.scoketAndNio.ch05.ch09_10;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test9_1 {
    private  static Set<SelectionKey> selectionKeySet;
    private static  SocketChannel socketChannel = null;
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey1 = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(20000);
                        System.out.println("cancel() after selector.keys().size()="+selector.keys().size());
                        socketChannel.write(ByteBuffer.wrap("123".getBytes()));
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            boolean isRun = true;
            while (isRun == true){
                selector.select();
                selectionKeySet = selector.selectedKeys();
                System.out.println("cancel() 1 before selector.keys().size()="+selector.keys().size());
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()){
                        ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                        socketChannel = channel.accept();
                    }
                    //cancel的作用是取消此键的通道到其选择器的注册.但是通道没有关闭仍然可以
                    //注意:关闭通道会使对应的键无效
                    key.cancel();
                }
                System.out.println("cancel() 2 before selector.keys().size()="+selector.keys().size());
            }
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}













