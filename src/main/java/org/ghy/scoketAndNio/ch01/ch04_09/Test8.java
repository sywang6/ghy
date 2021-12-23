package org.ghy.scoketAndNio.ch01.ch04_09;

import java.nio.ByteBuffer;

public class Test8 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(100);
        byteBuffer1.putChar('a');
        System.out.println(byteBuffer1.position());
        byteBuffer1.putChar(2,'b');
        System.out.println(byteBuffer1.position());

        byteBuffer1.position(4);
        byteBuffer1.putDouble(1.1);
        byteBuffer1.putDouble(12,1.2);

        byteBuffer1.position(20);
        byteBuffer1.putFloat(2.1F);
        byteBuffer1.putFloat(24,2.2F);

        byteBuffer1.position(28);
        byteBuffer1.putInt(31);
        byteBuffer1.putInt(32,32);

        byteBuffer1.position(36);
        byteBuffer1.putLong(41L);
        byteBuffer1.putLong(44,42L);

        byteBuffer1.position(52);
        byteBuffer1.putShort((short) 51);
        byteBuffer1.putShort(54,(short)52);

        byteBuffer1.position(0);

        byte[] byteArrayOut = byteBuffer1.array();
        for (int i = 0; i < byteArrayOut.length; i++) {
            //System.out.println(byteArrayOut[i]+" ");
        }
        System.out.println();
        System.out.println(byteBuffer1.getChar());
        System.out.println(byteBuffer1.getChar(2));
        byteBuffer1.position(4);
        System.out.println(byteBuffer1.getDouble());
        System.out.println(byteBuffer1.getDouble(12));
        byteBuffer1.position(20);
        System.out.println(byteBuffer1.getFloat());
        System.out.println(byteBuffer1.getFloat(24));
        byteBuffer1.position(28);
        System.out.println(byteBuffer1.getInt());
        System.out.println(byteBuffer1.getInt(32));
        byteBuffer1.position(36);
        System.out.println(byteBuffer1.getLong());
        System.out.println(byteBuffer1.getLong(44));
        byteBuffer1.position(52);
        System.out.println(byteBuffer1.getShort());
        System.out.println(byteBuffer1.getShort(54));

    }
}
