package org.ghy.multiThreadFrame.ch04.ch03_11;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQequeTest2 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(2);
        System.out.println(arrayBlockingQueue.size());
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,3,
                5, TimeUnit.SECONDS,arrayBlockingQueue);
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        //核心线程数2,最大线程数3,任务队列2,有一个任务被拒绝了
        System.out.println(poolExecutor.getPoolSize()+" "+arrayBlockingQueue.size());
    }
}
