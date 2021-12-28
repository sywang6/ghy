package org.ghy.scoketAndNio.ch02.ch04_19;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Test16_6 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020419_Test16_6.txt");
        RandomAccessFile fileA = new RandomAccessFile(file,"rw");
        FileChannel fileChannel = fileA.getChannel();
        MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,0,100);
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            byteBuffer.put("a".getBytes());
            //MappedByteBuffer调用force()方法,强制刷盘,性能较Test16_5急剧下降
            byteBuffer.force();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
        fileChannel.close();
        fileA.close();

    }
}
