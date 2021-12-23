package org.ghy.scoketAndNio.ch02.ch04_03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//批量写入,long write(ByteBuffer[] srcs)具有同步特性
public class Test3_3 {
    private static   FileOutputStream fosRef;
    private static FileChannel fileChannel;
    public static void main(String[] args) throws IOException, InterruptedException {
         fosRef = new FileOutputStream(new File("f:\\var\\020403_Test3_3.txt"));
         fileChannel = fosRef.getChannel();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(){
                @Override
                public void run() {
                    try {
                        ByteBuffer buffer1 = ByteBuffer.wrap("ooooo1\r\n".getBytes());
                        ByteBuffer buffer2 = ByteBuffer.wrap("ooooo2\r\n".getBytes());
                        ByteBuffer[] byteBufferArray = new ByteBuffer[]{buffer1,buffer2};
                        fileChannel.write(byteBufferArray);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            };
            Thread thread2 = new Thread(){
                @Override
                public void run() {
                    try {
                        ByteBuffer buffer1 = ByteBuffer.wrap("zzzzz1\r\n".getBytes());
                        ByteBuffer buffer2 = ByteBuffer.wrap("zzzzz2\r\n".getBytes());
                        ByteBuffer[] byteBufferArray = new ByteBuffer[]{buffer1,buffer2};
                        fileChannel.write(byteBufferArray);
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
