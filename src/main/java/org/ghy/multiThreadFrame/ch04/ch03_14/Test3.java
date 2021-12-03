package org.ghy.multiThreadFrame.ch04.ch03_14;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor execitor = new ThreadPoolExecutor(1,1,100, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        execitor.submit(runnable1);
        execitor.submit(runnable2);
        Thread.sleep(1000);
        System.out.println("删除任务1"+execitor.remove(runnable1));
        System.out.println("删除任务2"+execitor.remove(runnable2));

    }
}
