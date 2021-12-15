package org.ghy.scoketAndNio.ch01.ch03_04;

import java.nio.CharBuffer;
//remaining(),剩余空间大小. 等于limit-positon.由于limit位置是不可写的,直接相减就获得了剩余空间的大小
public class Test4 {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a','b','c','d','e'};
        CharBuffer charBuffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity()="+charBuffer.capacity()+" limit()="+charBuffer.limit()+" position()="+charBuffer.position());
        charBuffer.position(2);
        System.out.println("B capacity()="+charBuffer.capacity()+" limit()="+charBuffer.limit()+" position()="+charBuffer.position());
        System.out.println("C remaining()="+charBuffer.remaining());
    }
}
