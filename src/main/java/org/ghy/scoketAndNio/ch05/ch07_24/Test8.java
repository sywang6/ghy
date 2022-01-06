package org.ghy.scoketAndNio.ch05.ch07_24;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Test8 {
    public static void main(String[] args) {
        try {
            //使用open(SocketAddress remote)方法创建一个SocketChannel,该方法内部已经执行了连接操作.而有些配置项是需要在
            //连接之前配置的,否则不会生效
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost",8088));
            //可通过抓包,查看接收缓冲区的大小
            socketChannel.setOption(StandardSocketOptions.SO_RCVBUF,1234);
            socketChannel.write(ByteBuffer.wrap("我是中国人我来自客户端!".getBytes()));
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
