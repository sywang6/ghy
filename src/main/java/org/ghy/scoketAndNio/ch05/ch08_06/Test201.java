package org.ghy.scoketAndNio.ch05.ch08_06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test201 {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel1 = ServerSocketChannel.open();
            serverSocketChannel1.bind(new InetSocketAddress("localhost",7777));
            serverSocketChannel1.configureBlocking(false);

            ServerSocketChannel serverSocketChannel2 = ServerSocketChannel.open();
            serverSocketChannel2.bind(new InetSocketAddress("localhost",8888));
            serverSocketChannel2.configureBlocking(false);

            ServerSocketChannel serverSocketChannel3 = ServerSocketChannel.open();
            serverSocketChannel3.bind(new InetSocketAddress("localhost",9999));
            serverSocketChannel3.configureBlocking(false);

            Selector selector1 = Selector.open();

            SelectionKey selectionKey1 = serverSocketChannel1.register(selector1,SelectionKey.OP_ACCEPT);
            SelectionKey selectionKey2 = serverSocketChannel2.register(selector1,SelectionKey.OP_ACCEPT);
            SelectionKey selectionKey3 = serverSocketChannel3.register(selector1,SelectionKey.OP_ACCEPT);

            boolean isRun = true;
            while (isRun == true){
                //返回值表示要添加到就绪集合中的数目
                int keyCount = selector1.select();
                Set<SelectionKey> set1 = selector1.keys();
                Set<SelectionKey> set2 = selector1.selectedKeys();
                System.out.println("keysCount="+keyCount);
                System.out.println("set1 size="+set1.size());
                System.out.println("set2 size="+set2.size());
                System.out.println();
                Iterator<SelectionKey> iterator = set2.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel)key.channel();
                    serverSocketChannel.accept();
                }
                Thread.sleep(10000);
            }
            serverSocketChannel1.close();
            serverSocketChannel2.close();
            serverSocketChannel3.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//首先运行Test201,在连续两次运行Test202,输出;
//keysCount=1
//set1 size=3
//set2 size=1

//keysCount=0 为0的意思是以就绪集合中已经存在selectionKey1,不需要在添加到已继续的集合中去
//set1 size=3
//set2 size=1

//先运行Test201 在依次运行Test202 和Test203,输出如下
//keysCount=1
//set1 size=3
//set2 size=1

//keysCount=2
//set1 size=3
//set2 size=3