package org.ghy.scoketAndNio.ch02.ch04_06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts, int offset, int length)方法具有同步性
public class Test6_4 {
    private static FileInputStream fisRef;
    private static FileChannel fileChannel;
    public static void main(String[] args) throws IOException, InterruptedException {
        fisRef = new FileInputStream(new File("f:\\var\\020406_Test6_4.txt"));
        fileChannel = fisRef.getChannel();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    try {
                        ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
                        ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
                        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
                        long readLength = fileChannel.read(byteBufferArray,0,2);
                        while (readLength != -1){
                            synchronized (Test6_4.class){
                                for (int j = 0; j < byteBufferArray.length; j++) {
                                    byte[] getByte = byteBufferArray[j].array();
                                    for (int k = 0; k < getByte.length; k++) {
                                        System.out.print(((char)getByte[k]));
                                    }
                                }
                            }
                            byteBuffer1.clear();
                            byteBuffer2.clear();
                            readLength = fileChannel.read(byteBufferArray,0,2);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            };


            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    try {
                        ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
                        ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
                        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
                        long readLength = fileChannel.read(byteBufferArray,0,2);
                        while (readLength != -1){
                            synchronized (Test6_4.class){
                                for (int j = 0; j < byteBufferArray.length; j++) {
                                    byte[] getByte = byteBufferArray[j].array();
                                    for (int k = 0; k < getByte.length; k++) {
                                        System.out.print(((char)getByte[k]));
                                    }
                                }
                            }
                            byteBuffer1.clear();
                            byteBuffer2.clear();
                            readLength = fileChannel.read(byteBufferArray,0,2);
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
