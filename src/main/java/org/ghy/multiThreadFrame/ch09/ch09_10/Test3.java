package org.ghy.multiThreadFrame.ch09.ch09_10;

import java.util.concurrent.ForkJoinPool;

public class Test3 {
    public static void main(String[] args) {
        try {
            MyRunnable2 myRunnable2 = new MyRunnable2();
            ForkJoinPool pool = new ForkJoinPool();
            pool.execute(myRunnable2);
            Thread.sleep(1000);
            pool.shutdownNow();
            pool.execute(myRunnable2);
            System.out.println("main end!");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
