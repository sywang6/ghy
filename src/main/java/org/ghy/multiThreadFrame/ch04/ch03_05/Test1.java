package org.ghy.multiThreadFrame.ch04.ch03_05;

import org.ghy.multiThreadFrame.ch01.ch01_15.ThreadP;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable  myRunnable = new MyRunnable();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,99999,9999L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        poolExecutor.execute(myRunnable);
        System.out.println("main begin "+System.currentTimeMillis());
        //awaitTermination具有阻塞的特性,任务4秒就执行完成了(但是池子没关闭),main线程要10秒才执行完成
        System.out.println(poolExecutor.awaitTermination(10,TimeUnit.SECONDS));
        System.out.println("main end "+System.currentTimeMillis());

    }
}
