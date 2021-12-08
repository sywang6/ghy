package org.ghy.multiThreadFrame.ch09.ch09_01;

import java.util.concurrent.ForkJoinPool;

public class Run {
    public static void main(String[] args) {

        try {
            ForkJoinPool pool = new ForkJoinPool();
            pool.execute(new MyRecursiveAction());
            System.out.println("main end");
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
