package org.ghy.multiThreadFrame.ch01.ch01_05;

import java.util.concurrent.Semaphore;

public class Service {

    private Semaphore semaphore = new Semaphore(2);

    public void testMethod(){
        try{
            if("A".equals(Thread.currentThread().getName())){
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" begin timer "+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName()+" end timer "+System.currentTimeMillis());
                semaphore.release();
            }else{
                System.out.println(semaphore.availablePermits()+" "+semaphore.drainPermits());
                System.out.println(semaphore.availablePermits()+" "+semaphore.drainPermits());
                Thread.sleep(2500);
                System.out.println(semaphore.availablePermits()+" "+semaphore.drainPermits());
                System.out.println(semaphore.availablePermits()+" "+semaphore.drainPermits());
            }

        }catch (InterruptedException e){
            System.out.println("线程"+Thread.currentThread().getName()+"进入了try-catch");
            e.printStackTrace();
        }
    }
}
