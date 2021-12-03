package org.ghy.multiThreadFrame.ch04.ch03_08;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,4,4, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        poolExecutor.allowCoreThreadTimeOut(true);
        System.out.println(poolExecutor.allowsCoreThreadTimeOut());
        for (int i = 0; i < 4; i++) {
            poolExecutor.execute(new MyRunnable());
        }
        Thread.sleep(1000);
        System.out.println(poolExecutor.getPoolSize());
        Thread.sleep(1000);
        System.out.println(poolExecutor.getPoolSize());
        Thread.sleep(1000);
        System.out.println(poolExecutor.getPoolSize());
        Thread.sleep(1000);
        System.out.println(poolExecutor.getPoolSize());
        Thread.sleep(1000);
        System.out.println(poolExecutor.getPoolSize());
        poolExecutor.allowCoreThreadTimeOut(false);
        for (int i = 0; i < 4; i++) {
            poolExecutor.execute(new MyRunnable());
        }
    }
}
