package org.ghy.multiThreadFrame.ch04.ch03_08;

import org.ghy.multiThreadFrame.ch01.ch01_15.ThreadP;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4,5,5, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        System.out.println(poolExecutor.allowsCoreThreadTimeOut());
        for (int i = 0; i < 4; i++) {
            poolExecutor.execute(new MyRunnable());
        }
        Thread.sleep(8000);
        System.out.println(poolExecutor.getPoolSize());
    }
}
