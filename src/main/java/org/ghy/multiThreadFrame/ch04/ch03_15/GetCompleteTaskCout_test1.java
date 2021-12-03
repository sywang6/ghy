package org.ghy.multiThreadFrame.ch04.ch03_15;

import org.ghy.multiThreadFrame.ch01.ch01_15.ThreadP;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GetCompleteTaskCout_test1 {
    public static void main(String[] args) {
        try {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,5,100, TimeUnit.SECONDS,
                    new SynchronousQueue<Runnable>());
            poolExecutor.prestartAllCoreThreads();
            //书中的解释是有多少个线程已经执行完任务了,这个解释是错误的.这个方法的作用是表示已经执行完成了多少个任务
            System.out.println(poolExecutor.getCompletedTaskCount());
            poolExecutor.execute(runnable);
            poolExecutor.execute(runnable);
            poolExecutor.execute(runnable);
            System.out.println(poolExecutor.getCompletedTaskCount());
            Thread.sleep(7000);
            System.out.println(poolExecutor.getCompletedTaskCount());
            poolExecutor.execute(runnable);
            poolExecutor.execute(runnable);
            Thread.sleep(7000);
            System.out.println(poolExecutor.getCompletedTaskCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
