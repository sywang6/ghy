package org.ghy.multiThreadFrame.ch04.ch03_11;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingDequeTest2 {
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
        poolExecutor.execute(new MyRunnable());
        //核心线程2最大线程3,任务队列最多两个,有一个任务被拒绝
        System.out.println(poolExecutor.getPoolSize()+" "+linkedBlockingDeque.size());
    }
}
