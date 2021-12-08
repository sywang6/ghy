package org.ghy.multiThreadFrame.ch09.ch09_05;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Run {
    public static void main(String[] args) {

        try {
            ForkJoinPool pool = new ForkJoinPool();
            System.out.println("begin "+System.currentTimeMillis());
            ForkJoinTask task = pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                        System.out.println("ThreadName="+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            //Runnable没有返回值,get()返回为null
            System.out.println(task.get());
            System.out.println(" end "+System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
