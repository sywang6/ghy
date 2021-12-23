package org.ghy.scoketAndNio.ch02.ch04_07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证int write(ByteBuffer src, long position)方法具有同步特性
public class Test7_3 {
    private static FileOutputStream fosRef;
    private static FileChannel fileChannel;
    public static void main(String[] args) throws IOException, InterruptedException {
         fosRef = new FileOutputStream(new File("f:\\var\\020407_Test7_3.txt"));
         fileChannel = fosRef.getChannel();

        Thread thread1 = new Thread(){
          public void run(){
              try {
                  System.out.println("线程1运行");
                  ByteBuffer buffer = ByteBuffer.wrap("12345".getBytes());
                  fileChannel.write(buffer,0);
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
        };

        Thread thread2 = new Thread(){
            public void run(){
                try {
                    System.out.println("线程2运行");
                    ByteBuffer buffer = ByteBuffer.wrap("67890".getBytes());
                    fileChannel.write(buffer,0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        fileChannel.close();
        fosRef.close();

    }
}
