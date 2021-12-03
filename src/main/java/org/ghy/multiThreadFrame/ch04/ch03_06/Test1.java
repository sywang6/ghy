package org.ghy.multiThreadFrame.ch04.ch03_06;

import org.ghy.multiThreadFrame.ch01.ch01_15.ThreadP;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,99999,
                9999, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(),new MyThreadFactoryA());
        poolExecutor.execute(myRunnable);
    }
}
