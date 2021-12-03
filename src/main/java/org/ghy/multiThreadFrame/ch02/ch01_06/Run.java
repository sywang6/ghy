package org.ghy.multiThreadFrame.ch02.ch01_06;

import java.util.concurrent.CountDownLatch;

public class Run {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        System.out.println("main getCount1="+countDownLatch.getCount());
        countDownLatch.countDown();
        System.out.println("main getCount2="+countDownLatch.getCount());
        countDownLatch.countDown();
        System.out.println("main getCount3="+countDownLatch.getCount());
        countDownLatch.countDown();
        System.out.println("main getCount4="+countDownLatch.getCount());
        countDownLatch.countDown();
        System.out.println("main getCount5="+countDownLatch.getCount());
        countDownLatch.countDown();
        System.out.println("main getCount6="+countDownLatch.getCount());
        countDownLatch.countDown();
    }
}
