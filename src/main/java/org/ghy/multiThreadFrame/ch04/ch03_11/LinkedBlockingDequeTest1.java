package org.ghy.multiThreadFrame.ch04.ch03_11;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingDequeTest1 {
    public static void main(String[] args) {
        LinkedBlockingDeque<Runnable> linkedBlockingDeque = new LinkedBlockingDeque<>(2);
        System.out.println(linkedBlockingDeque.size());
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,3,
                5, TimeUnit.SECONDS,linkedBlockingDeque);
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        //核心线程数2,最大线程数3,任务队列2,所有任务都能得到运行
        System.out.println(poolExecutor.getPoolSize()+" "+linkedBlockingDeque.size());
    }
}
