package org.ghy.multiThreadFrame.ch04.ch03_10;

import org.ghy.multiThreadFrame.ch01.ch01_15.ThreadP;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(" 打印了! "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,2,5,
                TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        Thread.sleep(1000);
        System.out.println(executor.getCompletedTaskCount());
        Thread.sleep(1000);
        System.out.println(executor.getCompletedTaskCount());
        Thread.sleep(1000);
        System.out.println(executor.getCompletedTaskCount());
        Thread.sleep(1000);
        System.out.println(executor.getCompletedTaskCount());
        Thread.sleep(1000);
        System.out.println(executor.getCompletedTaskCount());









    }
}
