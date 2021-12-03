package org.ghy.multiThreadFrame.ch02.ch01_02;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{
    private CountDownLatch maxRunner;

    public MyThread(CountDownLatch maxRunner) {
        this.maxRunner = maxRunner;
    }
    public void run(){
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+"到达终点!");
            maxRunner.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
