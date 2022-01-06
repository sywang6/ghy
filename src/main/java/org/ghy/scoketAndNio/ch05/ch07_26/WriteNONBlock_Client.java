package org.ghy.scoketAndNio.ch05.ch07_26;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class WriteNONBlock_Client {
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("localhost",7077));
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
