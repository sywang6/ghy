package org.ghy.multiThreadFrame.ch04.ch03_11;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynchronousQequeTest1 {
    public static void main(String[] args) {
        SynchronousQueue<Runnable> synchronousQueue = new SynchronousQueue<>();
        System.out.println(synchronousQueue.size());
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,3,
                5, TimeUnit.SECONDS,synchronousQueue);
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        poolExecutor.execute(new MyRunnable());
        //3个任务直接运行了,SynchronousQueue队列的容量大小为0
        System.out.println(poolExecutor.getPoolSize()+" "+synchronousQueue.size());
    }
}
