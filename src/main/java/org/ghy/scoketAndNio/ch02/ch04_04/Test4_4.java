package org.ghy.scoketAndNio.ch02.ch04_04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts)方法具有同步性
public class Test4_4 {

    private static FileInputStream fisRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws IOException, InterruptedException {
        fisRef = new FileInputStream(new File("f:\\var\\020404_Test4_4.txt"));
        fileChannel = fisRef.getChannel();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(){
              public void run(){
                  try {
                      ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
                      ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
                      ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
                      long readLength = fileChannel.read(byteBufferArray);
                      while (readLength != -1){
                          //同步的目的是输出的有序性
                          synchronized (Test4_4.class){
                              for (int i = 0; i < byteBufferArray.length; i++) {
                                  byte[] getByte = byteBufferArray[i].array();
                                  for (int j = 0; j < getByte.length; j++) {
                                      System.out.print((char)getByte[j]);
                                  }
                              }
                          }
                          byteBuffer1.clear();
                          byteBuffer2.clear();
                          readLength = fileChannel.read(byteBufferArray);
                      }
                  } catch (IOException e) {
                      e.printStackTrace();
                  }


              }
            };

            Thread thread2 = new Thread(){
                public void run(){
                    try {
                        ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
                        ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
                        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
                        long readLength = fileChannel.read(byteBufferArray);
                        while (readLength != -1){
                            //同步的目的是输出的有序性
                            synchronized (Test4_4.class){
                                for (int i = 0; i < byteBufferArray.length; i++) {
                                    byte[] getByte = byteBufferArray[i].array();
                                    for (int j = 0; j < getByte.length; j++) {
                                        System.out.print((char)getByte[j]);
                                    }
                                }
                            }
                            byteBuffer1.clear();
                            byteBuffer2.clear();
                            readLength = fileChannel.read(byteBufferArray);
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
