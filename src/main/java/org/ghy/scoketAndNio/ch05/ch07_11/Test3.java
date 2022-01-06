package org.ghy.scoketAndNio.ch05.ch07_11;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

public class Test3 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //获得阻塞锁对象configureBlocking()和register()方法实现同步的对象
            Object lock = serverSocketChannel.blockingLock();
            System.out.println(lock);
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
