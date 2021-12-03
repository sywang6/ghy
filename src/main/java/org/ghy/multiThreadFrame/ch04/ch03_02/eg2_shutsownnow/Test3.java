package org.ghy.multiThreadFrame.ch04.ch03_02.eg2_shutsownnow;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable2 myRunnable2 = new MyRunnable2();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,99999,9999, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>()
        );
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        Thread.sleep(1000);
        poolExecutor.shutdownNow();
        poolExecutor.execute(myRunnable2);
        System.out.println("main end!");
    }
}
