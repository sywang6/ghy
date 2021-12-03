package org.ghy.multiThreadFrame.ch04.ch02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) {
        MyThreadFactory     myThreadFactory = new MyThreadFactory();
        ExecutorService executorService = Executors.newCachedThreadPool(myThreadFactory);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("我在运行"+System.currentTimeMillis()+" "+Thread.currentThread().getName());
            }
        });
    }
}
