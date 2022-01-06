package org.ghy.scoketAndNio.ch05.ch07_24;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Test8_1 {
    public static void main(String[] args) {
        try {
            //正确的设置接收缓冲区的大小,可通过抓包查看接收缓冲区的大小
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.setOption(StandardSocketOptions.SO_RCVBUF,1234);
            socketChannel.connect(new InetSocketAddress("localhost",8088));
            socketChannel.write(ByteBuffer.wrap("我是中国人我来自客户端!".getBytes()));
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
