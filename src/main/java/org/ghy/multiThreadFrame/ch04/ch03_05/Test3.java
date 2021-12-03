package org.ghy.multiThreadFrame.ch04.ch03_05;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable2 myRunnable2 = new MyRunnable2();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,99999,9999,
                TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        poolExecutor.shutdown();
        System.out.println("A="+poolExecutor.awaitTermination(1,TimeUnit.SECONDS)+" "+System.currentTimeMillis());
        System.out.println("B="+poolExecutor.awaitTermination(1,TimeUnit.SECONDS)+" "+System.currentTimeMillis());
        System.out.println("C="+poolExecutor.awaitTermination(1,TimeUnit.SECONDS)+" "+System.currentTimeMillis());
        System.out.println("D="+poolExecutor.awaitTermination(1,TimeUnit.SECONDS)+" "+System.currentTimeMillis());
        System.out.println("E="+poolExecutor.awaitTermination(1,TimeUnit.SECONDS)+" "+System.currentTimeMillis());
        System.out.println("F="+poolExecutor.awaitTermination(1,TimeUnit.SECONDS)+" "+System.currentTimeMillis());
        System.out.println("G="+poolExecutor.awaitTermination(1,TimeUnit.SECONDS)+" "+System.currentTimeMillis());
    }
}
