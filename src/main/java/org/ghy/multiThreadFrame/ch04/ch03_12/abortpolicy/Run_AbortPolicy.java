package org.ghy.multiThreadFrame.ch04.ch03_12.abortpolicy;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run_AbortPolicy {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+" run end!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,5,
                TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),new ThreadPoolExecutor.AbortPolicy()
                );
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
    }
}
























