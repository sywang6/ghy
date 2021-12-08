package org.ghy.multiThreadFrame.ch09.ch09_09;

import java.util.concurrent.ForkJoinPool;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(myRunnable1);
        Thread.sleep(1000);
        //shutdown()之后任务还会继续运行
        pool.shutdown();
        System.out.println("main end!");
        Thread.sleep(10000);
    }
}
