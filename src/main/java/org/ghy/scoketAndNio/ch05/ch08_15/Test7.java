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

public class Test7 {
    private static Thread mainThread = Thread.currentThread();
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",7777));
            serverSocketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
            Thread client = new Thread(){
                public void run(){
                    try {
                        Thread.sleep(2000);
                        mainThread.interrupt();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            client.start();
            boolean isRun = true;
            while (isRun = true){
                System.out.println("begin "+System.currentTimeMillis());
                //阻塞会由于线程中断而结束,不会返回异常.
                int keyCount = selector.select();
                //清除中断标记.后续的keys()方法还能正常执行
                Thread.interrupted();
                System.out.println(" end "+System.currentTimeMillis()+" keyCount "+keyCount);
                Set<SelectionKey> keys = selector.keys();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()){
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
