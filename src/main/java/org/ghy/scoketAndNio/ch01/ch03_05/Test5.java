package org.ghy.scoketAndNio.ch01.ch03_05;

import java.nio.ByteBuffer;

//mark <= position <= limit <= capacity
//mark()在当前的position位置做个标记,position可以向前推进(位置++),当调用reset(),position就会重置为mark所在的位置.
//聪明的你是不是想到了如果position向后推进(位置--)呢?如果向后推进导致mark大于position,会设置mark=-1,当mark为负数时,调用reset就会抛出InvalidMarkException异常
//(稍微跟踪一下代码就知道了)
public class Test5 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        System.out.println("A capacity()="+byteBuffer.capacity()+" limit()="+byteBuffer.limit()+" position()="+byteBuffer.position());
        byteBuffer.position(1);
        byteBuffer.mark();//在位置1设置mark
        System.out.println("B capacity()="+byteBuffer.capacity()+" limit()="+byteBuffer.limit()+" position()="+byteBuffer.position());
        byteBuffer.position(2);
        byteBuffer.reset();
        System.out.println("C capacity()="+byteBuffer.capacity()+" limit()="+byteBuffer.limit()+" position()="+byteBuffer.position());

    }
}
