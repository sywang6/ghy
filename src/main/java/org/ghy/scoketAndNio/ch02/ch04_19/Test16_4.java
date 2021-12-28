package org.ghy.scoketAndNio.ch02.ch04_19;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Test16_4 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020419_Test16_4.txt");
        RandomAccessFile fileA = new RandomAccessFile(file,"rw");
        FileChannel fileChannel = fileA.getChannel();
        //专用模式,对MappedByteBuffer的写操作,不会更改底层文件.另一个进程对文件执行写操作,MappedByteBuffer内容会改变
        MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.PRIVATE,0,5);
        System.out.println("MappedByteBuffer capacity="+byteBuffer.capacity()+" limit="+byteBuffer.limit());
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.print((char)byteBuffer.get());
        }
        System.out.println();
        byteBuffer.rewind();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.print((char)byteBuffer.get());
        }

        byteBuffer.position(0);
        byteBuffer.put((byte)'o');
        byteBuffer.put((byte)'p');
        byteBuffer.put((byte)'q');
        byteBuffer.put((byte)'r');
        byteBuffer.put((byte)'s');
        fileChannel.close();
        fileA.close();

    }
}
