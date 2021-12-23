package org.ghy.scoketAndNio.ch02.ch04_04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts)方法是通道的当前位置开始读取的
public class Test4_2 {

    private static FileInputStream fisRef;
    private  static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020404_Test4_2.txt"));
        fileChannel = fisRef.getChannel();
        fileChannel.position(2);

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        long readLength = fileChannel.read(byteBufferArray);

        for (int i = 0; i < byteBufferArray.length; i++) {
            byte[] getByte = byteBufferArray[i].array();
            for (int j = 0; j < getByte.length; j++) {
                System.out.print((char)getByte[j]);
            }
            System.out.println();
        }


        fileChannel.close();
        fisRef.close();

    }
}
