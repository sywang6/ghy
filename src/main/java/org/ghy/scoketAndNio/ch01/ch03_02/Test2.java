package org.ghy.scoketAndNio.ch01.ch03_02;

import java.nio.CharBuffer;
//limit此位置是第一个不可读不可写的索引
public class Test2 {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a','b','c','d','e'};
        CharBuffer charBuffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity()="+charBuffer.capacity()+" limit()="+charBuffer.limit());//A capacity()=5 limit()=5
        charBuffer.limit(3);
        System.out.println();
        System.out.println("B capacity()="+charBuffer.capacity()+" limit()="+charBuffer.limit());//B capacity()=5 limit()=3
        charBuffer.put(0,'o');
        charBuffer.put(1,'p');
        charBuffer.put(2,'q');
        charBuffer.put(3,'r');//此位置是第一个不可读不可写的索引
        charBuffer.put(4,'s');
        charBuffer.put(5,'t');
        charBuffer.put(6,'u');
    }
}
