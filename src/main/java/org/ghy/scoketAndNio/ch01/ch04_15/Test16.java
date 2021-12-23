package org.ghy.scoketAndNio.ch01.ch04_15;

import java.nio.ByteBuffer;

//压缩操作不是很好理解. p=position()处的字节复制到索引0处, p+1 -> 1 ... limit()-1 ->  limit-1-p处, 然后将缓冲区的位置设置为 limit-p
//执行完compact,在执行flip,就可以接着前面的处理
public class Test16 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(new byte[]{1,2,3,4,5,6});
        System.out.println("A capacity="+byteBuffer1.capacity()+" position="+byteBuffer1.position()+" limit="+byteBuffer1.limit());
        System.out.println("1 getValue="+byteBuffer1.get());
        System.out.println("B capacity="+byteBuffer1.capacity()+" position="+byteBuffer1.position()+" limit="+byteBuffer1.limit());
        System.out.println("2 getValue="+byteBuffer1.get());
        System.out.println("C capacity="+byteBuffer1.capacity()+" position="+byteBuffer1.position()+" limit="+byteBuffer1.limit());
        byteBuffer1.compact();
        System.out.println("byteBuffer1.compact()");
        System.out.println("D capacity="+byteBuffer1.capacity()+" position="+byteBuffer1.position()+" limit="+byteBuffer1.limit());
        byte[] getByteArray = byteBuffer1.array();
        for (int i = 0; i < getByteArray.length; i++) {
            System.out.print(getByteArray[i]+" ");
        } //3 4 5 6 5 6
    }
}
