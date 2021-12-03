package org.ghy.multiThreadFrame.ch02.ch02_03;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyService {
    private CyclicBarrier cyclicBarrier;

    public MyService(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void beginRun(){

        try {
            long sleepValue = (int)(Math.random()*10000);
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName()+" "
            +System.currentTimeMillis()+" begin跑步第1阶段 "+(cyclicBarrier.getNumberWaiting()+1));
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+" "
                    +System.currentTimeMillis()+" end跑步第1阶段 "+(cyclicBarrier.getNumberWaiting()+1));
             sleepValue = (int)(Math.random()*10000);
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName()+" "
                    +System.currentTimeMillis()+" begin跑步第2阶段 "+(cyclicBarrier.getNumberWaiting()+1));
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+" "
                    +System.currentTimeMillis()+" end跑步第2阶段 "+(cyclicBarrier.getNumberWaiting()+1));
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

}
