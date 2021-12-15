package org.ghy.scoketAndNio.ch01.ch04_01;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

//手动释放直接缓冲区
public class Test1_Manual {
    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   System.out.println("A "+System.currentTimeMillis());
                   ByteBuffer byteBuffer = ByteBuffer.allocateDirect(Integer.MAX_VALUE);
                   System.out.println("B "+System.currentTimeMillis());
                   byte[] byteArray = new byte[]{1};
                   for (int i = 0; i < Integer.MAX_VALUE; i++) {
                       byteBuffer.put(byteArray);
                   }
                   System.out.println("put end! "+System.currentTimeMillis());
                   Thread.sleep(1000);
                   Method cleanerMethod = byteBuffer.getClass().getMethod("cleaner");
                   cleanerMethod.setAccessible(true);
                   Object retrunValue =  cleanerMethod.invoke(byteBuffer);
                   Method cleanMethod = retrunValue.getClass().getMethod("clean");
                   cleanMethod.setAccessible(true);
                   cleanMethod.invoke(retrunValue);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (NoSuchMethodException e) {
                   e.printStackTrace();
               } catch (IllegalAccessException e) {
                   e.printStackTrace();
               } catch (InvocationTargetException e) {
                   e.printStackTrace();
               }
           }
       }).start();

       Thread.sleep(Integer.MAX_VALUE);

    }
}
