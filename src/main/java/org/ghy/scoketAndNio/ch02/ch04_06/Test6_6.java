package org.ghy.scoketAndNio.ch02.ch04_06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts, int offset, int length)方法最多从通道读的字节放入缓冲区的remaining空间中
public class Test6_6 {
    public static void main(String[] args) throws IOException {
        FileInputStream fisRef = new FileInputStream(new File("f:\\var\\020406_Test6_6.txt"));
        FileChannel  fileChannel = fisRef.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(7);
        byteBuffer1.position(1);
        byteBuffer1.limit(3);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(7);
        byteBuffer2.position(2);
        byteBuffer2.limit(5);
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        long readLength = fileChannel.read(bufferArray,0,2);
        fileChannel.close();
        fisRef.close();
        byteBuffer1.rewind();
        byteBuffer2.rewind();
        for (int i = 0; i < bufferArray.length; i++) {
            ByteBuffer eachBuffer = bufferArray[i];
            byte[] byteArray = eachBuffer.array();
            for (int j = 0; j < byteArray.length; j++) {
                if(byteArray[j]==0){
                    System.out.print("空格");
                }else{
                    System.out.print((char)byteArray[j]);
                }
            }
            System.out.println();
        }



    }
}
