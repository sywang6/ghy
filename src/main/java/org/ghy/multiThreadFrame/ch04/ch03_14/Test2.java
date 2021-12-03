package org.ghy.multiThreadFrame.ch04.ch03_14;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" begin");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+" end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+" begin");
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName()+" end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor execitor = new ThreadPoolExecutor(1,1,100, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        execitor.execute(runnable1);
        execitor.execute(runnable2);
        Thread.sleep(1000);
        System.out.println("删除任务1"+execitor.remove(runnable1));
        System.out.println("删除任务2"+execitor.remove(runnable2));

    }
}
