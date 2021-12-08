package org.ghy.multiThreadFrame.ch09.ch09_13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(myRunnable1);
        pool.shutdown();
        System.out.println(System.currentTimeMillis());
        System.out.println(pool.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS)+
                " "+System.currentTimeMillis());

    }
}
