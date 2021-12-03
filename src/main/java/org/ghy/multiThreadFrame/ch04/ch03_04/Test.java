package org.ghy.multiThreadFrame.ch04.ch03_04;

import org.ghy.multiThreadFrame.ch01.ch01_15.ThreadP;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable runnable = new MyRunnable();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,99999,9999, TimeUnit.SECONDS
        ,new LinkedBlockingQueue<Runnable>());
        poolExecutor.execute(runnable);
        poolExecutor.execute(runnable);
        poolExecutor.execute(runnable);
        poolExecutor.execute(runnable);
        System.out.println(poolExecutor.isTerminating()+" "+poolExecutor.isTerminated());
        poolExecutor.shutdown();
        Thread.sleep(1000);
        System.out.println(poolExecutor.isTerminating()+" "+poolExecutor.isTerminated());
        Thread.sleep(1000);
        System.out.println(poolExecutor.isTerminating()+" "+poolExecutor.isTerminated());
        Thread.sleep(1000);
        System.out.println(poolExecutor.isTerminating()+" "+poolExecutor.isTerminated());
        Thread.sleep(1000);
        System.out.println(poolExecutor.isTerminating()+" "+poolExecutor.isTerminated());
        Thread.sleep(1000);
        System.out.println(poolExecutor.isTerminating()+" "+poolExecutor.isTerminated());

    }
}
