package org.ghy.scoketAndNio.ch01.ch05_02;

import java.nio.CharBuffer;
//charAt是相对于position的位置,注意与ByteBuffer的区别
public class Test2 {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(10);
        charBuffer.append("abcdefg");
        charBuffer.position(2);
        System.out.println(charBuffer.charAt(0));
        System.out.println(charBuffer.charAt(1));
        System.out.println(charBuffer.charAt(2));
    }
}
