package org.ghy.multiThreadFrame.ch04.ch03_15;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GetCorePoolSize_test1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,100,
                TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        System.out.println("getCorePoolSize="+executor.getCorePoolSize());
    }
}
