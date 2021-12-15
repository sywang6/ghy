package org.ghy.scoketAndNio.ch01.ch03_12;

import java.nio.ByteBuffer;
//判断当前位置与限制之间是否有剩余元素
public class Test13_1 {
    public static void main(String[] args) {
        byte[] byteArray = {1,2,3,4,5,6,7,8,9};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        int remaining = byteBuffer.remaining();
        for (int i = 0; i < remaining; i++) {
            System.out.print(byteBuffer.get()+" ");
        }
        System.out.println();
        byteBuffer.clear();
        while (byteBuffer.hasRemaining()){
            System.out.print(byteBuffer.get()+" ");
        }
        System.out.println();
        byteBuffer.clear();
        for(;byteBuffer.hasRemaining()==true;){
            System.out.print(byteBuffer.get()+" ");
        }

    }
}
