package org.ghy.multiThreadFrame.ch04.ch03_11;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingDequeTest3 {
    public static void main(String[] args) {
        LinkedBlockingDeque<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<>();
        System.out.println(linkedBlockingDeque.size());
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,3,
                5, TimeUnit.SECONDS,linkedBlockingDeque);
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        //核心线程2,最大线程3,队列里面放了3个任务
        System.out.println(poolExecutor.getPoolSize()+" "+linkedBlockingDeque.size());
    }
}
