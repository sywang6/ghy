package org.ghy.scoketAndNio.ch01.ch05_04;

import java.nio.CharBuffer;

public class Test4 {
    public static void main(String[] args) {
        CharBuffer charBuffer1 = CharBuffer.wrap("abcdefg",3,5);
        System.out.println(charBuffer1.capacity()+charBuffer1.limit()+charBuffer1.position());
        for (int i = 0; i < charBuffer1.limit(); i++) {
            System.out.print(charBuffer1.get(i)+" ");
        }
        charBuffer1.append("我是只读的,不能添加数据,会出现异常! ");
    }
}
