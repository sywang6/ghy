package org.ghy.multiThreadFrame.ch09.ch09_11;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Run2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE ; i++) {
                    String newString = new String();
                }
                for (int i = 0; i < 6; i++) {
                    Math.random();
                }
            }
        };
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask task = pool.submit(runnable);
        //Thread.sleep(1000);
        System.out.println("A="+pool.isTerminating());
        pool.shutdownNow();
        System.out.println("B="+pool.isTerminating());
        //CancellationException – if the computation was cancelled
        System.out.println(task.get());
        Thread.sleep(1000);
        System.out.println("C="+pool.isTerminated());
    }
}
