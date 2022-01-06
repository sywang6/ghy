package org.ghy.scoketAndNio.ch05.ch07_23;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Test6 {
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("localhost",8088));
            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_CONNECT);
            boolean isRun = true;
            while (isRun == true){
                System.out.println("begin selector");
                if(channel.isOpen() == true ){
                    selector.select();
                    System.out.println(" end selector");
                    Set<SelectionKey> set = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = set.iterator();
                    while (iterator.hasNext()){
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if(key.isConnectable()) {
                            while (!channel.finishConnect()) {

                            }
                            channel.register(selector, SelectionKey.OP_READ);
                        }
                            if(key.isReadable()){
                                ByteBuffer byteBuffer = ByteBuffer.allocate(50000);
                                int readLength = channel.read(byteBuffer);
                                byteBuffer.flip();
                                long count = 0;
                                while (readLength != -1){
                                    count = count+readLength;
                                    readLength = channel.read(byteBuffer);
                                    System.out.println("count="+count+" readLength="+readLength);
                                    byteBuffer.clear();
                                }
                                System.out.println("读取结束");
                                channel.close();
                            }
                        }
                    }
                else{
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
