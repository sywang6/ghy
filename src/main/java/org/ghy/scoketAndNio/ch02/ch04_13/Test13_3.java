package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_3 {

    private static FileOutputStream fileA;
    private  static FileChannel fileChannelA;

    public static void main(String[] args) throws IOException, InterruptedException {
        fileA = new FileOutputStream("f:\\var\\020413_Test13_3.txt");
        fileChannelA = fileA.getChannel();
        Thread a = new Thread(){
            @Override
            public void run() {
                try {
                    //可能出现AsynchronousCloseException异常,通道已经关闭
                    fileChannelA.lock(1,2,false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread b = new Thread(){
            @Override
            public void run() {
                try {
                    fileChannelA.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        a.start();
        Thread.sleep(1);
        b.start();
        Thread.sleep(1000);

        fileChannelA.close();
        fileA.close();


    }
}
