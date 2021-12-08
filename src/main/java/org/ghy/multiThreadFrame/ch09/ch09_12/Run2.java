package org.ghy.multiThreadFrame.ch09.ch09_12;

import java.util.concurrent.ForkJoinPool;

public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("打印了! begin "+Thread.currentThread().getName());
                    Thread.sleep(1000);
                    System.out.println("打印了! end"+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        ForkJoinPool pool = new ForkJoinPool();
        pool.execute(runnable);
        Thread.sleep(500);
        System.out.println("A="+pool.isShutdown());
        pool.shutdownNow();
        Thread.sleep(5000);
        System.out.println("B="+pool.isShutdown());

    }
}
