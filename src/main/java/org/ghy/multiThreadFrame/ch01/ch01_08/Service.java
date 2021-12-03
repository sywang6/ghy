package org.ghy.multiThreadFrame.ch01.ch01_08;

import java.util.concurrent.Semaphore;

public class Service {

    private Semaphore semaphore  = new Semaphore(1);

    public void testMethod(){
        //尝试获取许可证
        if(semaphore.tryAcquire()){
        System.out.println("线程"+Thread.currentThread().getName()+"首先进入! ");
            for (int i = 0; i < Integer.MAX_VALUE/50; i++) {
                String newString = new String();
                Math.random();
            }
            semaphore.release();
      }else{
            System.out.println("线程"+Thread.currentThread().getName()+"未成功进入! ");
        }
    }
}
