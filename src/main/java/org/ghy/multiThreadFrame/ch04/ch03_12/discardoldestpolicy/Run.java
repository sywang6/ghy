package org.ghy.multiThreadFrame.ch04.ch03_12.discardoldestpolicy;

import org.ghy.multiThreadFrame.ch04.ch03_11.ArrayBlockingQequeTest1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run {
    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(2);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,5, TimeUnit.SECONDS,
                queue, new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < 5; i++) {
            MyRunnable runnable = new MyRunnable("Runnable"+(i+1));
            executor.execute(runnable);
        }
        queue.stream().forEach(e->{
            System.out.println(((MyRunnable)e).getUsername());
        });
        executor.execute(new MyRunnable("Runnable6"));
        executor.execute(new MyRunnable("Runnable7"));
        queue.stream().forEach(e->{
            System.out.println(((MyRunnable)e).getUsername());
        });
    }
}
