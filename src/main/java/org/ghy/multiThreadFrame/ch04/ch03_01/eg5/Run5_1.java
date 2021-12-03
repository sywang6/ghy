package org.ghy.multiThreadFrame.ch04.ch03_01.eg5;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run5_1 {
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
        ThreadPoolExecutor executor = new ThreadPoolExecutor(7,10,
                0, TimeUnit.SECONDS,new SynchronousQueue<>());
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
        Thread.sleep(5000);
        System.out.println("B"+executor.getCorePoolSize());
        System.out.println("B"+executor.getPoolSize());
        System.out.println("B"+executor.getQueue().size());

    }
}
