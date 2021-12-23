package org.ghy.scoketAndNio.ch02.ch04_04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts)方法返回值的含义:
//正数:从通道里面读取的字节数
//0:没有从通道读取任何字节,可能是接收的buffer没有剩余空间了
//-1:已经到达流的末尾
public class Test4_1 {

    private static FileInputStream fisRef;
    private  static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020404_Test4_1.txt"));
        fileChannel = fisRef.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        long readLength = fileChannel.read(byteBufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();

        readLength = fileChannel.read(byteBufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();

        readLength = fileChannel.read(byteBufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();


        readLength = fileChannel.read(byteBufferArray);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();
        fileChannel.close();
        fisRef.close();

    }
}
