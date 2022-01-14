package org.ghy.scoketAndNio.ch05.ch12_01;

import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.nio.channels.Channel;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Pipe;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;

//SelectorProvider的使用
public class Test1 {
    public static void main(String[] args) {
        try {
            SelectorProvider provider = SelectorProvider.provider();
            System.out.println("provider="+provider.getClass().getName());
            Selector selector = provider.openSelector();
            DatagramChannel datagramChannel1 = provider.openDatagramChannel();
            DatagramChannel datagramChannel2 = provider.openDatagramChannel(StandardProtocolFamily.INET);
            DatagramChannel datagramChannel3 = provider.openDatagramChannel(StandardProtocolFamily.INET6);
            Pipe pipe = provider.openPipe();
            ServerSocketChannel serverSocketChannel = provider.openServerSocketChannel();
            SocketChannel socketChannel = provider.openSocketChannel();
            Channel channel = provider.inheritedChannel();
            System.out.println("openSelector()="+selector.getClass().getName());
            System.out.println("openDatagramChannel()="+datagramChannel1.getClass().getName());
            System.out.println("openDatagramChannel(StandardProtocolFamily.INET)="+datagramChannel2.getClass().getName());
            System.out.println("openDatagramChannel(StandardProtocolFamily.INET6)="+datagramChannel3.getClass().getName());
            System.out.println("openPipe()="+pipe.getClass().getName());
            System.out.println("openServerSocketChannel()="+serverSocketChannel.getClass().getName());
            System.out.println("openSocketChannel()="+socketChannel.getClass().getName());
            System.out.println("inheritedChannel()="+channel);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
