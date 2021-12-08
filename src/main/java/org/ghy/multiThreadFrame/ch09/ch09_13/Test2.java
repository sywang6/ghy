package org.ghy.multiThreadFrame.ch09.ch09_13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(myRunnable1);
        pool.shutdown();
        System.out.println("main begin ! "+System.currentTimeMillis());
        System.out.println(pool.awaitTermination(10, TimeUnit.SECONDS));
        System.out.println("main end ! "+System.currentTimeMillis());
    }
}
