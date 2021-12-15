package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

//当limit和position值一样时,在指定的position写入数据时会出现异常,因为此位置是被限制的
public class Test7 {
    public static void main(String[] args) {
      char[] charArray = new char[]{'a','b','c','d'};
        CharBuffer charBuffer = CharBuffer.wrap(charArray);
        System.out.println("A capacity()="+charBuffer.capacity()+" limit()="+charBuffer.limit()+" position()="+charBuffer.position());
        charBuffer.position(1);
        charBuffer.limit(1);
        charBuffer.put('z');
    }
}
