package org.ghy.scoketAndNio.ch05.ch07_13;

import java.io.IOException;
import java.net.StandardSocketOptions;
import java.nio.channels.ServerSocketChannel;

public class Test5 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //获得与设置SocketOption
            System.out.println( "A SO_RCVBUF"+serverSocketChannel.getOption(StandardSocketOptions.SO_RCVBUF));
            serverSocketChannel.setOption(StandardSocketOptions.SO_RCVBUF,5678);
            System.out.println( "A SO_RCVBUF"+serverSocketChannel.getOption(StandardSocketOptions.SO_RCVBUF));
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
