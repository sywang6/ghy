package org.ghy.multiThreadFrame.ch04.ch03_05;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable  myRunnable = new MyRunnable();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,99999,9999L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        poolExecutor.execute(myRunnable);
        poolExecutor.shutdown();
        System.out.println("main begin "+System.currentTimeMillis());
        //任务4秒执行完成之后,池子关闭,awaitTermination返回,不会阻塞10秒钟
        System.out.println(poolExecutor.awaitTermination(10,TimeUnit.SECONDS));
        System.out.println("main end "+System.currentTimeMillis());

    }
}
