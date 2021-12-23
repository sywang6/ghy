package org.ghy.scoketAndNio.ch02.ch04_05;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long write(ByteBuffer[] srcs, int offset, int length)方法具有同步特性
public class Test5_3 {
    private static FileOutputStream fosRef;
    private static FileChannel fileChannel;

    private static int count = 0;
    synchronized  public static ByteBuffer[] getByteBufferArray(String printString1,String printString2){
        ++count;
        ByteBuffer byteBuffer1 = ByteBuffer.wrap((printString1+count+"\r\n").getBytes());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap((printString2+count+"\r\n").getBytes());
        ByteBuffer[] returnArray = {byteBuffer1,byteBuffer2};
        return returnArray;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
         fosRef = new FileOutputStream(new File("f:\\var\\020405_Test5_3.txt"));
         fileChannel = fosRef.getChannel();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    try {
                        ByteBuffer[] bufferArray = getByteBufferArray("aaaa","bbbb");
                        fileChannel.write(bufferArray,0,2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    try {
                        ByteBuffer[] bufferArray = getByteBufferArray("xxxx","yyyy");
                        fileChannel.write(bufferArray,0,2);
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
        fosRef.close();

    }
}
