package org.ghy.scoketAndNio.ch02.ch04_05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long write(ByteBuffer[] srcs, int offset, int length)是从通道的当前位置开始写入的.
//offset为ByteBuffer数组的偏移量
public class Test5_1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fosRef = new FileOutputStream(new File("f:\\var\\020405_Test5_1.txt"));
        FileChannel fileChannel = fosRef.getChannel();

        ByteBuffer byteBuffer1 = ByteBuffer.wrap("abcde".getBytes());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap("12345".getBytes());
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        fileChannel.write(ByteBuffer.wrap("qqqqq".getBytes()));
        fileChannel.position(2);
        fileChannel.write(byteBufferArray,0,1);
        fileChannel.close();
        fosRef.close();
    }
}
