package org.ghy.scoketAndNio.ch01.ch05_05;

import java.nio.CharBuffer;

//CharBuffer的remaining()与length()逻辑一致
public class Test5 {
    public static void main(String[] args) {
        CharBuffer  charBuffer1 = CharBuffer.wrap("abcd");
        System.out.println("position="+charBuffer1.position()+" remaining="+
                charBuffer1.remaining()+" length="+charBuffer1.length());
        System.out.println(charBuffer1.get());
        System.out.println("position="+charBuffer1.position()+" remaining="+
                charBuffer1.remaining()+" length="+charBuffer1.length());
        System.out.println(charBuffer1.get());
        System.out.println("position="+charBuffer1.position()+" remaining="+
                charBuffer1.remaining()+" length="+charBuffer1.length());
        System.out.println(charBuffer1.get());
        System.out.println("position="+charBuffer1.position()+" remaining="+
                charBuffer1.remaining()+" length="+charBuffer1.length());
        System.out.println(charBuffer1.get());
        System.out.println("position="+charBuffer1.position()+" remaining="+
                charBuffer1.remaining()+" length="+charBuffer1.length());
    }
}
