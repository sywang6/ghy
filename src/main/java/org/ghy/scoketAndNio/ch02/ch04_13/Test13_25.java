package org.ghy.scoketAndNio.ch02.ch04_13;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

//先运行Test13_24在运行Test13_24,独占锁与共享锁是互斥关系
public class Test13_25 {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_24.txt","rw");
            FileChannel fileChannel = fileA.getChannel();
            System.out.println("begin "+System.currentTimeMillis());
            fileChannel.lock(0,Long.MAX_VALUE,true);
            System.out.println(" end"+ System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
