package org.ghy.multiThreadFrame.ch04.ch03_06;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) {
        MyRunnable2 myRunnable = new MyRunnable2();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,99999,
                9999, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        poolExecutor.setThreadFactory(new MyThreadFactoryB());
        poolExecutor.execute(myRunnable);
    }
}
