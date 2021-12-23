package org.ghy.scoketAndNio.ch02.ch04_08;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证read(ByteBuffer dst,long position)方法具有同步特性
public class Test8_3 {
    private static RandomAccessFile fisRef;
    private  static FileChannel fileChannel;
    private static ByteBuffer byteBuffer1 = ByteBuffer.allocate((int)(1024*1024*1024*1.3));

    public static void main(String[] args) throws IOException, InterruptedException {
        fisRef = new RandomAccessFile(new File("f:\\var\\020408_Test8_3.txt"),"rw");
       fileChannel = fisRef.getChannel();
       Thread thread1 = new Thread(){
           @Override
           public void run() {
               try {
                   fileChannel.read(byteBuffer1,0);
                   System.out.println(" end thread1 "+System.currentTimeMillis());
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       } ;
       Thread thread2 = new Thread(){
         public void run(){
             try {
                 fileChannel.write(ByteBuffer.wrap("1111111111".getBytes()),fileChannel.size()+1);
                 System.out.println(" end thread2 "+System.currentTimeMillis());
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
       };
        System.out.println(" begin time "+System.currentTimeMillis());
        thread1.start();
        Thread.sleep(100);
        thread2.start();
        thread1.join();
        thread2.join();
        fileChannel.close();
        fisRef.close();
    }

}
