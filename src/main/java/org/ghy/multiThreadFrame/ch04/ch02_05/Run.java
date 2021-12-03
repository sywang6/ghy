package org.ghy.multiThreadFrame.ch04.ch02_05;

import org.ghy.multiThreadFrame.ch04.ch02_03.MyThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory();
        ExecutorService executorService = Executors.newFixedThreadPool(2,myThreadFactory);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executorService.execute(runnable);
        executorService.execute(runnable);
        executorService.execute(runnable);

    }
}
