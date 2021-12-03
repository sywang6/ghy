package org.ghy.multiThreadFrame.ch02.ch02_02;

import java.util.concurrent.CyclicBarrier;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        ThreadA threadA1 = new ThreadA(cyclicBarrier);
        threadA1.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());

        ThreadA threadA2 = new ThreadA(cyclicBarrier);
        threadA2.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());

        ThreadA threadA3 = new ThreadA(cyclicBarrier);
        threadA3.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());

        ThreadA threadA4 = new ThreadA(cyclicBarrier);
        threadA4.start();
        Thread.sleep(500);
        System.out.println(cyclicBarrier.getNumberWaiting());


    }
}
