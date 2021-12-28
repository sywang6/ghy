package org.ghy.scoketAndNio.ch02.ch04_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
//文件锁的位置,大小,是否可用,共享锁or独占锁?
public class FileLockAPI_1 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020417_Test17_1.txt");
        RandomAccessFile fileA = new RandomAccessFile(file,"rw");
        FileChannel fileChannel = fileA.getChannel();
        System.out.println("fileChannel.hashCode="+fileChannel.hashCode());
        FileLock lock  = fileChannel.lock(1,10,true);
        System.out.println("A position="+lock.position()+" size="+lock.size()+" isValid="+lock.isValid()+
                " isShared="+lock.isShared()+" channel().hashCode()="+lock.channel().hashCode()+" acquiredBy().hashCode()="+
                lock.acquiredBy().hashCode());
        lock.release();
        lock = fileChannel.lock(1,10,false);
        System.out.println("B position="+lock.position()+" size="+lock.size()+" isValid="+lock.isValid()+
                " isShared="+lock.isShared()+" channel().hashCode()="+lock.channel().hashCode()+" acquiredBy().hashCode()="+
                lock.acquiredBy().hashCode());
        lock.close();
        fileChannel.close();
        System.out.println("C position="+lock.position()+" size="+lock.size()+" isValid="+lock.isValid()+
                " isShared="+lock.isShared()+" channel().hashCode()="+lock.channel().hashCode()+" acquiredBy().hashCode()="+
                lock.acquiredBy().hashCode());


    }
}
