package org.ghy.multiThreadFrame.ch04.ch03_09;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
                    Thread.sleep(4000);
                    System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,2,5,
                TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        System.out.println("线程池中的线程数A: "+poolExecutor.getPoolSize());
        System.out.println("启动核心线程数量为:"+poolExecutor.prestartAllCoreThreads());
        System.out.println("线程池中的线程数B: "+poolExecutor.getPoolSize());
    }
}
