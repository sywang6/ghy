package org.ghy.scoketAndNio.ch02.ch04_08;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证read(ByteBuffer dst,long position)方法将字节放入ByteBuffer当前位置
//给定的位置大于该文件的当前大小,则不读取任何字节
public class Test8_2 {
    private static FileInputStream fisRef;
    private  static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020408_Test8_2.txt"));
        fileChannel = fisRef.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        byteBuffer.position(3);
        fileChannel.read(byteBuffer,2);
        byte[] getByteArray = byteBuffer.array();
        for (int i = 0; i < getByteArray.length; i++) {
            if(getByteArray[i] == 0){
                System.out.print("空格");
            }else{
                System.out.print((char)getByteArray[i]);
            }
        }

        fileChannel.close();
        fisRef.close();
    }

}
