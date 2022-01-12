package org.ghy.scoketAndNio.ch05.ch09_06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

//先运行ch09_05中的Test5_1,在运行该程序,使用attach追加附件,会覆盖以前的附件
public class Test5_3 {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            Selector selector = Selector.open();
            SelectionKey selectionKey1 = socketChannel.register(selector,SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("localhost",8888));
            boolean isRun = true;
            while (isRun == true){
                int keyCount = selector.select();
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    if(key.isConnectable()){
                        System.out.println("client isConnectable()");
                        if(socketChannel.isConnectionPending()){
                            while (!socketChannel.finishConnect()){
                                System.out.println("!socketChannel.finishConnect()---");
                            }
                        }
                        socketChannel.register(selector,SelectionKey.OP_WRITE);
                        Object obj = key.attach("我使用attach(Object)进行注册,我来自客户端,你好服务端1");
                        System.out.println(obj);
                         obj = key.attach("我使用attach(Object)进行注册,我来自客户端,你好服务端2");
                        System.out.println(obj);
                    }
                    if(key.isWritable()){
                        System.out.println("client isWritable()");
                        ByteBuffer buffer = ByteBuffer.wrap(((String)key.attachment()).getBytes());
                        socketChannel.write(buffer);
                        socketChannel.close();
                    }
                }
            }
            System.out.println("client end!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







