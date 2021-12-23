package org.ghy.scoketAndNio.ch01.ch05_01;

import java.nio.CharBuffer;

//CharBuffer的append方法
public class Test1 {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(15);
        System.out.println("A "+charBuffer.position());
        charBuffer.append('a');
        System.out.println("B "+charBuffer.position());
        charBuffer.append("bcdefg");
        System.out.println("C "+charBuffer.position());
        charBuffer.append("abchjklmnopqrst",3,8);
        System.out.println("D "+charBuffer.position());
        char[] newArray = charBuffer.array();
        for (int i = 0; i < charBuffer.limit(); i++) {
            System.out.print(newArray[i]+" ");
        }
        System.out.println();
        System.out.println("charBuffer capacity=" +charBuffer.capacity());
    }

}
