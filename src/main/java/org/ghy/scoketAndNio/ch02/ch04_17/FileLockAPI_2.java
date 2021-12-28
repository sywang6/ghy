package org.ghy.scoketAndNio.ch02.ch04_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockAPI_2 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020417_Test17_2.txt");
        RandomAccessFile fileA = new RandomAccessFile(file,"rw");
        FileChannel fileChannel =  fileA.getChannel();
        FileLock lock = fileChannel.lock(1,10,true);
        //测试锁的位置与position到position+size位置有没有重叠
        System.out.println(lock.overlaps(5,10));
        lock.close();
    }
}
