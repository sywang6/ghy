package org.ghy.scoketAndNio.ch05.ch07_04;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Test4 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(3);
            //SocketChannel配合nio的ByteBuffer读取数据
            int readLangth = socketChannel.read(byteBuffer);
            while (readLangth != -1){
                String newString = new String(byteBuffer.array());
                System.out.print(newString);
                byteBuffer.flip();
                readLangth =socketChannel.read(byteBuffer);
            }
            socketChannel.close();
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
