package org.ghy.scoketAndNio.ch02.ch04_04;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts)方法将字节放入ByteBuffer的当前位置
public class Test4_3 {

    private static FileInputStream fisRef;
    private  static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020404_Test4_3.txt"));
        fileChannel = fisRef.getChannel();
        fileChannel.position(2);

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
       byteBuffer1.position(1);

        long readLength = fileChannel.read(byteBufferArray);

        for (int i = 0; i < byteBufferArray.length; i++) {
            byte[] getByte = byteBufferArray[i].array();
            for (int j = 0; j < getByte.length; j++) {
                if (getByte[j]==0){
                    System.out.print("空格");
                }else{
                    System.out.print((char)getByte[j]);
                }
            }
            System.out.println();
        }
        fileChannel.close();
        fisRef.close();

    }
}
