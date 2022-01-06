package org.ghy.scoketAndNio.ch05.ch07_17;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class Test8 {
    public static void main(String[] args) {
        try {
            //SelectorProvider线程安全
            SelectorProvider provider1 = SelectorProvider.provider();
            System.out.println(provider1);
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            SelectorProvider provider2 = serverSocketChannel.provider();
            System.out.println(provider2);
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
