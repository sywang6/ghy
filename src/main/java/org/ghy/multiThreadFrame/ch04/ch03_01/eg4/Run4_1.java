package org.ghy.multiThreadFrame.ch04.ch03_01.eg4;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run4_1 {
    public static void main(String[] args) throws InterruptedException {
       Runnable runnable = new Runnable() {
           @Override
           public void run() {
                try{
                    System.out.println(Thread.currentThread().getName()+" run!"+System.currentTimeMillis());
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
           }
       } ;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,8,
                5, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        executor.execute(runnable);
        Thread.sleep(300);
        System.out.println("A"+executor.getCorePoolSize());
        System.out.println("A"+executor.getPoolSize());
        System.out.println("A"+executor.getQueue().size());
        Thread.sleep(10000);
        System.out.println("B"+executor.getCorePoolSize());
        System.out.println("B"+executor.getPoolSize());
        System.out.println("B"+executor.getQueue().size());

    }
}
