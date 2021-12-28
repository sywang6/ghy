package org.ghy.scoketAndNio.ch02.ch04_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Test16_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("f:\\var\\020419_Test16_1.txt");
        RandomAccessFile file1A = new RandomAccessFile(file,"rw");
        FileChannel fileChannel = file1A.getChannel();
        //Channel直接映射到内存,只读模式
        MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,5);
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,2,2);
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        Thread.sleep(500);
        System.out.println();
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        file1A.close();
        fileChannel.close();
    }
}
