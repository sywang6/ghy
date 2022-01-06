package org.ghy.scoketAndNio.ch05.ch07_25;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

//文件传输
public class BigFileServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress("localhost",8088));
            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_ACCEPT);
            boolean isRun = true;
            while (isRun == true ){
                selector.select();
                Set<SelectionKey> set = selector.selectedKeys();
                Iterator<SelectionKey> iterator = set.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if(key.isAcceptable()){
                        SocketChannel socketChannel = channel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_WRITE);
                    }
                    if(key.isWritable()){
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        //C:\Users\shiyou.wang\Downloads\jdk-8u291-windows-x64.exe
                        FileInputStream file = new FileInputStream("C:\\Users\\shiyou.wang\\Downloads\\jdk-8u291-windows-x64.exe");
                        FileChannel fileChannel = file.getChannel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(52428800);
                        while (fileChannel.position()<fileChannel.size()){
                            fileChannel.read(byteBuffer);
                            byteBuffer.flip();
                            while (byteBuffer.hasRemaining()){
                                socketChannel.write(byteBuffer);
                            }
                            byteBuffer.clear();
                            System.out.println(fileChannel.position()+" "+fileChannel.size());
                        }
                        System.out.println("结束写操作");
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









