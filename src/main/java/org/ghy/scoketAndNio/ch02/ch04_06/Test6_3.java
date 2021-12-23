package org.ghy.scoketAndNio.ch02.ch04_06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts, int offset, int length)方法将字节放入ByteBuffer当前位置
public class Test6_3 {
    private static FileInputStream fisRef;
    private static FileChannel fileChannel;
    public static void main(String[] args) throws IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020406_Test6_3.txt"));
        fileChannel = fisRef.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(8);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(8);
        byteBuffer1.position(3);
        byteBuffer2.position(4);
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        long readLength = fileChannel.read(byteBufferArray,0,2);

        for (int i = 0; i < byteBufferArray.length; i++) {
            ByteBuffer eachByteBuffer = byteBufferArray[i];
            byte[] getByteArray = eachByteBuffer.array();
            for (int j = 0; j < getByteArray.length; j++) {
                if(getByteArray[j]==0){
                    System.out.print("空格");
                }else{
                    System.out.print((char)getByteArray[j]);
                }
            }
            System.out.println();
        }
        fileChannel.close();
        fisRef.close();



    }
}
