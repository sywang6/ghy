package org.ghy.scoketAndNio.ch02.ch04_19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Test16_2 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020419_Test16_2.txt");
        RandomAccessFile fileA = new RandomAccessFile(file,"rw");
        FileChannel fileChannel = fileA.getChannel();
        MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,5);
        //此行出现异常,因为是只读,不允许更改数据.另一个进程对文件执行写操作,MappedByteBuffer内容会改变
        byteBuffer.putChar('1');
    }
}
