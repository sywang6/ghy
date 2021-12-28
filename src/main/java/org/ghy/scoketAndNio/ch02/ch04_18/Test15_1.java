package org.ghy.scoketAndNio.ch02.ch04_18;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test15_1 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020418_Test15_1.txt");
        if(file.exists() == false){
            file.createNewFile();
        }else{
            file.delete();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileChannel fileChannel = fileOutputStream.getChannel();
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            fileChannel.write(ByteBuffer.wrap("abcde".getBytes()));
            //默认不强制刷盘
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
        fileChannel.close();
        fileOutputStream.close();
    }
}
