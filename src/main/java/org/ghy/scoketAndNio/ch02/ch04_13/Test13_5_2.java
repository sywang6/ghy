package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_5_2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    RandomAccessFile file = new RandomAccessFile("f:\\var\\020413_Test13_5_1&2.txt","rw");
                    FileChannel fileChannel = file.getChannel();
                    System.out.println("B begin");
                    //先运行Test13_5_1,在运行Test13_5_2,20s后出现FileLockInterruptionException,因为线程已经中断
                    fileChannel.lock(0,2,false);
                    System.out.println("B end");
                    Thread.sleep(20000);
                    fileChannel.close();
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    t.start();
    Thread.sleep(2000);
    t.interrupt();
    }
}
