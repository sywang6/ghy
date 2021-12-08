package org.ghy.multiThreadFrame.ch09.ch09_10;

import java.util.concurrent.ForkJoinPool;

public class Test1  {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(myRunnable1);
        Thread.sleep(2000);
        pool.shutdownNow();
        pool.submit(myRunnable1);
    }
}
