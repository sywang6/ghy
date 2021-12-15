package org.ghy.scoketAndNio.ch01.ch03_03;

import java.nio.CharBuffer;

//position()要读取或写入元素的索引
public class Test3 {
    public static void main(String[] args) {
        char[] charArray = new char[]{'a','b','c','d'};
        CharBuffer charBuffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity()="+charBuffer.capacity()+" limit()="+charBuffer.limit()+" position()="+charBuffer.position());
        //charBuffer.limit(3);
       // charBuffer.position(4);
        charBuffer.position(2);
        System.out.println("B capacity()="+charBuffer.capacity()+" limit()="+charBuffer.limit()+" position()="+charBuffer.position());
        charBuffer.put("z");
        for (int i = 0; i < charArray.length; i++) {
            System.out.print(charArray[i]+" ");
        }
    }
}
