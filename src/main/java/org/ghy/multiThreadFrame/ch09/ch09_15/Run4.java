package org.ghy.multiThreadFrame.ch09.ch09_15;

import java.util.concurrent.ForkJoinPool;

public class Run4 {
    public static void main(String[] args) throws InterruptedException {
        MyRecursiveTask4 myRecursiveTask4 = new MyRecursiveTask4();
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.isQuiescent());
        pool.submit(myRecursiveTask4);
        Thread.sleep(1000);
        System.out.println(pool.isQuiescent());
    }
}
