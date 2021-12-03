package org.ghy.multiThreadFrame.ch05.ch02_09;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test4 {
    public static void main(String[] args) {

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(50,Integer.MAX_VALUE,
                5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        executorService.setThreadFactory(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println("execute方法通过使用自定义ThreadFactory也能捕获异常了");
                        e.printStackTrace();
                    }
                });
                return t;
            }
        });
        try {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Integer.parseInt("a");
                }
            });
        } catch (Exception e) {
            System.out.println("ex");
            e.printStackTrace();
        }


    }
}
