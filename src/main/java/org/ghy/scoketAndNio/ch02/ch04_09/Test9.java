package org.ghy.scoketAndNio.ch02.ch04_09;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//position(long newPosition)的作用是设置此通道的文件位置.将该位置为大于文件当前大小的值是合法的.
//但这不会更改文件的大小,稍后试图在这样的位置读取字节将立即返回已到达文件末尾的指示,稍后试图在这种位置写入字节将导致文件扩大,以容纳新的字节,在以前文件末尾和新写入字节之间的
//字节值是未指定的
public class Test9 {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer1 = ByteBuffer.wrap("abcd".getBytes());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap("cde".getBytes());
        FileOutputStream fileOutputStream = new FileOutputStream(new File("f:\\var\\020409_Test9.txt"));
        FileChannel fileChannel = fileOutputStream.getChannel();
        System.out.println("A position="+fileChannel.position()+" size="+fileChannel.size());
        fileChannel.write(byteBuffer1);
        System.out.println("B position="+fileChannel.position()+" size="+fileChannel.size());
        fileChannel.position(2);
        System.out.println("C position="+fileChannel.position()+" size="+fileChannel.size());
        fileChannel.write(byteBuffer2);
        System.out.println("D position="+fileChannel.position()+" size="+fileChannel.size());
        fileChannel.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
