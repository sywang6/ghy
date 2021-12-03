package org.ghy.multiThreadFrame.ch02.ch01_03;

import java.util.concurrent.CountDownLatch;

public class MyService {
   private CountDownLatch countDownLatch = new CountDownLatch(1);

   public  void testMethod(){
       try {
           if("runner5".equals(Thread.currentThread().getName())){
               Thread.sleep(5000);
           }
           System.out.println(Thread.currentThread().getName()+"准备");
           countDownLatch.await();
           System.out.println(Thread.currentThread().getName()+"结束");
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }

   public  void downMethod(){
       System.out.println("开始");
       countDownLatch.countDown();
   }

}
