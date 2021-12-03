package org.ghy.multiThreadFrame.ch04.ch03_09;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run1 {
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
        System.out.println("Z1="+poolExecutor.prestartCoreThread());
        System.out.println("线程池中的线程数B: "+poolExecutor.getPoolSize());
        System.out.println("Z2="+poolExecutor.prestartCoreThread());
        System.out.println("线程池中的线程数C: "+poolExecutor.getPoolSize());
        System.out.println("Z3="+poolExecutor.prestartCoreThread());
        System.out.println("Z4="+poolExecutor.prestartCoreThread());
        System.out.println("Z5="+poolExecutor.prestartCoreThread());
        System.out.println("Z6="+poolExecutor.prestartCoreThread());
        System.out.println("线程池中的线程数D: "+poolExecutor.getPoolSize());




    }
}
