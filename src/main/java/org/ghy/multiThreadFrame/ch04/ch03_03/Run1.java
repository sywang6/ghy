package org.ghy.multiThreadFrame.ch04.ch03_03;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run1 {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("打印了!begin"+Thread.currentThread().getName());
                    //Thread.sleep(1000);
                    System.out.println("打印了! end"+Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,2,Integer.MAX_VALUE
        , TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        poolExecutor.execute(runnable);
        System.out.println("A="+poolExecutor.isShutdown());
        poolExecutor.shutdownNow();
        System.out.println("A="+poolExecutor.isShutdown());

    }
}
