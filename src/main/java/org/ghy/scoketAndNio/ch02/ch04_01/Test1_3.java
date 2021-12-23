package org.ghy.scoketAndNio.ch02.ch04_01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//int write(ByteBuffer src)方法是同步的,稍微跟踪一下代码就知道啦,需要获得FileChannelImpl的positionLock锁
public class Test1_3 {
    private static FileOutputStream fosRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws InterruptedException, IOException {
        fosRef = new FileOutputStream(new File("f:\\var\\020401_Test1_3.txt"));
        fileChannel = fosRef.getChannel();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(){
              public void run(){
                  try {
                      ByteBuffer buffer = ByteBuffer.wrap("abcde\r\n".getBytes());
                      fileChannel.write(buffer);
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
            };

            Thread thread2 = new Thread(){
                public void run(){
                    try {
                        ByteBuffer buffer = ByteBuffer.wrap("我是中国人\r\n".getBytes());
                        fileChannel.write(buffer);
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
