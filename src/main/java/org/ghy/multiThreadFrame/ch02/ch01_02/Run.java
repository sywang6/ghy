package org.ghy.multiThreadFrame.ch02.ch01_02;

import java.util.concurrent.CountDownLatch;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch maxRunner = new CountDownLatch(10);
        MyThread[] myThreads = new MyThread[ (int)maxRunner.getCount()];
        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i] = new MyThread(maxRunner);
            myThreads[i].setName("runner"+(i+1));
            myThreads[i].start();
        }
        maxRunner.await();
        System.out.println("都回来了");
    }
}
