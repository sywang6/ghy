package org.ghy.scoketAndNio.ch02.ch04_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//int read(ByteBuffer dst)方法具有同步特性
public class Test2_4 {
    private static FileInputStream fisRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws InterruptedException, IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020402_Test2_4.txt"));
        fileChannel = fisRef.getChannel();

        for (int i = 0; i < 1; i++) {
             Thread  thread1 = new Thread() {
                 @Override
                 public void run() {
                     try {
                         ByteBuffer byteBuffer = ByteBuffer.allocate(5);
                         int readLength =  fileChannel.read(byteBuffer);
                         while (readLength != -1){
                             byte[] getByte = byteBuffer.array();
                             System.out.println(new String(getByte,0,readLength));
                             byteBuffer.clear();
                             readLength = fileChannel.read(byteBuffer);
                         }
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             };

            Thread  thread2 = new Thread() {
                @Override
                public void run() {
                    try {
                        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
                        int readLength =  fileChannel.read(byteBuffer);
                        while (readLength != -1){
                            byte[] getByte = byteBuffer.array();
                            System.out.println(new String(getByte,0,readLength));
                            byteBuffer.clear();
                            readLength = fileChannel.read(byteBuffer);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread1.start();
            thread2.start();
        }

        Thread.sleep(3000);

        fileChannel.close();
        fisRef.close();


    }
}
