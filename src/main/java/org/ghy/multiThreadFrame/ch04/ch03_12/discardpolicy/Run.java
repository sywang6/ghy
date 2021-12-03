package org.ghy.multiThreadFrame.ch04.ch03_12.discardpolicy;

import sun.nio.ch.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+" run end!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        };
        ArrayBlockingQueue queue = new ArrayBlockingQueue(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,1, TimeUnit.SECONDS
        ,queue,new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 10; i++) {
            executor.execute(runnable);
        }
       Thread.sleep(8000);
    System.out.println(executor.getPoolSize()+" "+queue.size());

    }
}
