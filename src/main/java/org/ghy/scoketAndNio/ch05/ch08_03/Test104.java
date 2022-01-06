package org.ghy.scoketAndNio.ch05.ch08_03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test104 {
    public static void main(String[] args){
        try {
            ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
            serverSocketChannel1.bind(new InetSocketAddress("localhost",7777));
            serverSocketChannel1.configureBlocking(false);

            ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
            serverSocketChannel2.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel2.configureBlocking(false);

            Selector selector1 = Selector.open();

            SelectionKey selectionKey1 = serverSocketChannel1.register(selector1,SelectionKey.OP_ACCEPT);
            SelectionKey selectionKey2 = serverSocketChannel2.register(selector1,SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun == true){
                int keyCount = selector1.select();
                //所有事件
                Set<SelectionKey> set1 = selector1.keys();
                //已就绪的事件
                Set<SelectionKey> set2 = selector1.selectedKeys();
                System.out.println("keyCount="+keyCount);
                System.out.println("set1 size="+set1.size());
                System.out.println("set2 size="+set2.size());
                Iterator<SelectionKey> iterator = set2.iterator();
                while (iterator.hasNext()){
                    //先运行Test05,在运行Test06,已就绪的事件处理完,没有移除,导致运行Test06时重复处理了
                    SelectionKey key = iterator.next();
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    if(socketChannel == null){
                        System.out.println("打印这条消息证明是连接8888服务器时,重复消费的情况发生,");
                        System.out.println("将7777关联的SelectionKey对应的SocketChannel通道取出来,");
                        System.out.println("但是值为null,socketChannel==null.");
                    }
                    InetSocketAddress ipAddress = (InetSocketAddress)serverSocketChannel.getLocalAddress();
                    System.out.println(ipAddress.getPort()+" 被客户端连接了! ");
                    System.out.println();
                }
            }
            serverSocketChannel1.close();
            serverSocketChannel2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
