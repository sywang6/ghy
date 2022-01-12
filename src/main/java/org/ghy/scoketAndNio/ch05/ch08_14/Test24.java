package org.ghy.scoketAndNio.ch05.ch08_14;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test24 {
    private  static Selector selector;
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        selector.wakeup();
                        Set<SelectionKey> set1 = selector.keys();
                        Set<SelectionKey> set2 = selector.selectedKeys();
                        System.out.println("执行wakeup()方法之后的selector的信息");
                        System.out.println("set1.size()="+set1.size());
                        System.out.println("set2.size()="+set2.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            SelectionKey selectionKey1 = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            //没执行wakeup之前会阻塞, 执行完wakeup会继续向下执行,但已继续集合中没有元素
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
            System.out.println("main end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
