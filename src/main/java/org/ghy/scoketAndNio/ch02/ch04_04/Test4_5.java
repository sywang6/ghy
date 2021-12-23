package org.ghy.scoketAndNio.ch02.ch04_04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts)方法从通道读取的数据大于缓冲区容量,则做多读取缓冲区容量的字节数
public class Test4_5 {

    private static FileInputStream fisRef;
    private  static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020404_Test4_5.txt"));
        fileChannel = fisRef.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        System.out.println("A "+fileChannel.position());
        long readLength = fileChannel.read(byteBufferArray);
        System.out.println("B "+fileChannel.position()+" readLength="+readLength);
        fileChannel.close();
        fisRef.close();

        byteBuffer1.flip();
        byteBuffer2.flip();
        for (int i = 0; i < byteBufferArray.length; i++) {
            ByteBuffer eachBuffer = byteBufferArray[i];
            for (int j = 0; j < eachBuffer.limit(); j++) {
                System.out.print((char)eachBuffer.get());
            }
            System.out.println();
        }


    }
}
