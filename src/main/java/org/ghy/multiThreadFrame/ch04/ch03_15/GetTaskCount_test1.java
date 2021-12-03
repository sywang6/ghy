package org.ghy.multiThreadFrame.ch04.ch03_15;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GetTaskCount_test1 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,100, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        for(int i=0;i<10;i++){
            executor.execute(runnable);
        }
        System.out.println(executor.getTaskCount());
        Thread.sleep(5000);
        System.out.println(executor.getTaskCount());
    }
}













