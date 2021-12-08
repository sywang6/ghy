package org.ghy.multiThreadFrame.ch09.ch09_13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable2 myRunnable2 = new MyRunnable2();
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(myRunnable2);
        pool.shutdown();
        System.out.println("A="+pool.awaitTermination(1, TimeUnit.SECONDS)+" "+System.currentTimeMillis());
        System.out.println("A="+pool.awaitTermination(1, TimeUnit.SECONDS)+" "+System.currentTimeMillis());
    }
}
