package org.ghy.multiThreadFrame.ch04.ch03_02.eg1_shutsown;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,99999,9999,
                TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        poolExecutor.execute(myRunnable1);
        poolExecutor.execute(myRunnable1);
        poolExecutor.execute(myRunnable1);
        poolExecutor.execute(myRunnable1);
        Thread.sleep(1000);
        poolExecutor.shutdown();
        poolExecutor.execute(myRunnable1);
        System.out.println("main end!");
    }
}
