package org.ghy.scoketAndNio.ch05.ch07_23;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test5 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            SocketChannel socketChannel = null;
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress("localhost",8088));
            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun == true){
                selector.select();
                Set<SelectionKey> set = selector.selectedKeys();
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext()){
                    SelectionKey  key = iterator.next();
                    iterator.remove();
                    if(key.isAcceptable()){
                        socketChannel = channel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_WRITE);
                    }
                    if(key.isWritable()){
                        //大文件
                        RandomAccessFile file = new RandomAccessFile("C:\\Users\\shiyou.wang\\Downloads\\jdk-8u291-windows-x64.exe","rw");
                        System.out.println("file.length()="+file.length());
                        FileChannel fileChannel = file.getChannel();
                        //文件传输
                        fileChannel.transferTo(0,file.length(),socketChannel);
                        fileChannel.close();
                        file.close();
                        socketChannel.close();
                    }
                }
            }
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
