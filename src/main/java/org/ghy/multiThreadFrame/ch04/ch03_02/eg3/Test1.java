package org.ghy.multiThreadFrame.ch04.ch03_02.eg3;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        try {
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                    2,10,30, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>()
            );
            poolExecutor.execute(new MyRunnableA("A1"));
            poolExecutor.execute(new MyRunnableA("A2"));
            poolExecutor.execute(new MyRunnableA("A3"));
            poolExecutor.execute(new MyRunnableA("A4"));
            Thread.sleep(1000);
            poolExecutor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
