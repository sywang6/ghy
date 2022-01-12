package org.ghy.scoketAndNio.ch05.ch09_10;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Test9_2 {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            //socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost",8888));
            ByteBuffer buffer = ByteBuffer.allocate(1000);
           int readLength =   socketChannel.read(buffer);
            System.out.println(new String(buffer.array(),0,readLength));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
