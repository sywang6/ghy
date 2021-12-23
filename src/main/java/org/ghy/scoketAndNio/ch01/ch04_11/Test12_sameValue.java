package org.ghy.scoketAndNio.ch01.ch04_11;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Test12_sameValue {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] byteArrayIn1 = "我是中国人".getBytes("utf-16BE");
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        //asCharBuffer()生成的缓冲区与byteBuffer1操作的是同一个数组
        CharBuffer charBuffer = byteBuffer1.asCharBuffer();

        byteBuffer1.put(2,"为".getBytes("utf-16BE")[0]);
        byteBuffer1.put(3,"为".getBytes("utf-16BE")[1]);

        for (int i = 0; i < charBuffer.limit(); i++) {
            System.out.print(charBuffer.get()+" ");
        }


    }
}
