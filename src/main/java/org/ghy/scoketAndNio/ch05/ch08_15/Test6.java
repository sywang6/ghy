package org.ghy.scoketAndNio.ch05.ch08_15;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test6 {
    private  static Selector selector;
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",7777));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            SelectionKey selectionKey1 = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            Thread client = new Thread(){
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
            client.start();
            boolean isRun = true;
            while (isRun == true){
                System.out.println("begin "+System.currentTimeMillis());
                //阻塞会由于其他线程调用选取的器的close方法而中断.
                //被中断后select放到不会抛出异常,但接下来的keys方法会抛出异常
                int keyCount = selector.select();
                System.out.println(" end "+System.currentTimeMillis());
                Set<SelectionKey> keys = selector.keys();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if(key.isAcceptable()){
                        ServerSocketChannel channel = (ServerSocketChannel)key.channel();
                        ServerSocket serverSocket = channel.socket();
                        Socket socket = serverSocket.accept();
                        socket.close();
                    }
                }
            }
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
