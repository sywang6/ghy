package org.ghy.scoketAndNio.ch01.ch04_01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

//自动回收直接缓存区
public class Test1_Automatic {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("A "+System.currentTimeMillis());
               ByteBuffer byteBuffer = ByteBuffer.allocateDirect(Integer.MAX_VALUE);
               System.out.println("B "+System.currentTimeMillis());
               byte[] byteArray = new byte[]{1};
               for (int i = 0; i < Integer.MAX_VALUE; i++) {
                   byteBuffer.put(byteArray);
               }
               System.out.println("put end! "+System.currentTimeMillis());
           }
       }).start();
       Thread.sleep(Integer.MAX_VALUE);

    }
}
