package org.ghy.scoketAndNio.ch02.ch04_04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts)方法从通道读取的字节放入缓冲区的remaining
public class Test4_6 {

    private static FileInputStream fisRef;
    private  static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        FileInputStream fisRef = new FileInputStream(new File("f:\\var\\020404_Test4_6.txt"));
        FileChannel fileChannel = fisRef.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(7);
        byteBuffer1.position(1);
        byteBuffer1.limit(3);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(7);
        byteBuffer2.position(2);
        byteBuffer2.limit(4);
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        long readLength = fileChannel.read(byteBufferArray);
        fileChannel.close();
        fisRef.close();
        byteBuffer1.rewind();
        byteBuffer2.rewind();
        for (int i = 0; i < byteBufferArray.length; i++) {
            ByteBuffer eachBuffer = byteBufferArray[i];
            byte[] byteArray = eachBuffer.array();
            for (int j = 0; j < byteArray.length; j++) {
                byte eachByte = byteArray[j];
                if (eachByte == 0){
                    System.out.print("空格");
                }else{
                    System.out.print((char)byteArray[j]);
                }
            }
            System.out.println();
        }



    }
}
