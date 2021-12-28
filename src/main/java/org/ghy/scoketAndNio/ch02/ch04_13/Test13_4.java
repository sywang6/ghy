package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_4 {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fis = new FileOutputStream("f:\\var\\020413_Test13_4.txt");
        FileChannel  fileChannel = fis.getChannel();
        Thread t1 = new Thread(){
            public void run() {
                try {
                    for (int i = 0; i < 1000000; i++) {
                       System.out.println("i="+(i+1));
                    }
                    //出现FileLockInterruptionException异常,因为线程已经中断
                    fileChannel.lock(1,2,false);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        Thread.sleep(50);
        t1.interrupt();
        Thread.sleep(30000);
        fileChannel.close();
        fis.close();
    }
}
