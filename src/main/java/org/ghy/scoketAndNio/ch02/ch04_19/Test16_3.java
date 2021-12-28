package org.ghy.scoketAndNio.ch02.ch04_19;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Test16_3 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020419_Test16_3.txt");
        RandomAccessFile fileA = new RandomAccessFile(file,"rw");
        FileChannel fileChannel = fileA.getChannel();
        //读写模式,对byteBuffer的写操作,会改变文件.另一个进程对文件执行写操作,MappedByteBuffer内容会改变
        MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,0,5);
        System.out.println("MappedByteBuffer capacity="+byteBuffer.capacity()+" limit="+byteBuffer.limit());
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
        System.out.println((char)byteBuffer.get()+" position="+byteBuffer.position());
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
