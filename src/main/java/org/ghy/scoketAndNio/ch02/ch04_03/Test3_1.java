package org.ghy.scoketAndNio.ch02.ch04_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//批量写入,long write(ByteBuffer[] srcs)是从通道开始位置开始写入的
public class Test3_1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fosRef = new FileOutputStream(new File("f:\\var\\020403_Test3_1.txt"));
        FileChannel fileChannel = fosRef.getChannel();
        fileChannel.write(ByteBuffer.wrap("123456".getBytes()));
        fileChannel.position(3);
        ByteBuffer buffer1 = ByteBuffer.wrap("ooooo1".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("ooooo2".getBytes());
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{buffer1,buffer2};
        fileChannel.write(byteBufferArray);
        fileChannel.close();
        fosRef.close();
    }

}
