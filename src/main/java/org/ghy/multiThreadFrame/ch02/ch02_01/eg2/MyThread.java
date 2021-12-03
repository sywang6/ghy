package org.ghy.multiThreadFrame.ch02.ch02_01.eg2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread extends Thread{
    private CyclicBarrier cyclicBarrier;

    public MyThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run(){
        try{
            Thread.sleep((int)(Math.random()*1000));
            System.out.println(Thread.currentThread().getName()+"到了"+System.currentTimeMillis()+"等待凑齐2个就发车!");
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName()+"结束"+System.currentTimeMillis()+"已经凑齐2个发车!");
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (BrokenBarrierException e){
            e.printStackTrace();
        }

    }
}
