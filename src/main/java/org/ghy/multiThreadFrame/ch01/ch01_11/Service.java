package org.ghy.multiThreadFrame.ch01.ch01_11;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Service {

    private Semaphore semaphore  = new Semaphore(3);

    public void testMethod(){
        //尝试获取许可证
        try {
            System.out.println("线程"+Thread.currentThread().getName()+"开始! "+System.currentTimeMillis());
            if(semaphore.tryAcquire(3,3, TimeUnit.SECONDS)){
            System.out.println("线程"+Thread.currentThread().getName()+"首先进入! "+System.currentTimeMillis());
            int  n=0;
            for (long i = 0; i < Long.MAX_VALUE; i++) {
                    String str = new String();
                }
                semaphore.release(3);
          }else{
                System.out.println("线程"+Thread.currentThread().getName()+"未成功进入! "+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
