package org.ghy.multiThreadFrame.ch04.ch03_02.eg1_shutsown;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(7,10,0,
                TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        System.out.println("main end!");
    }
}
