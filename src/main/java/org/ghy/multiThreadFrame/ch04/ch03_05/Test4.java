package org.ghy.multiThreadFrame.ch04.ch03_05;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2,99999,9999, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.execute(myRunnable);
        pool.shutdown();
        System.out.println(pool.awaitTermination(Integer.MAX_VALUE,TimeUnit.SECONDS)+" "+System.currentTimeMillis()+" 全部任务执行完毕! ");

    }
}
