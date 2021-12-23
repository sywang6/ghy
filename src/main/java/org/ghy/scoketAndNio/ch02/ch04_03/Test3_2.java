package org.ghy.scoketAndNio.ch02.ch04_03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//批量写入,long write(ByteBuffer[] srcs)是将ByteBuffer的remaining写入通道
public class Test3_2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fosRef = new FileOutputStream(new File("f:\\var\\020403_Test3_2.txt"));
        FileChannel fileChannel = fosRef.getChannel();
        fileChannel.write(ByteBuffer.wrap("123456".getBytes()));
        fileChannel.position(3);

        ByteBuffer buffer1 = ByteBuffer.wrap("abcde1".getBytes());
        ByteBuffer buffer2 = ByteBuffer.wrap("uvwxy2".getBytes());
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{buffer1,buffer2};


        buffer1.position(1);
        buffer1.limit(3);
        buffer2.position(2);
        buffer2.limit(4);


        fileChannel.write(byteBufferArray);
        fileChannel.close();
        fosRef.close();
    }

}
