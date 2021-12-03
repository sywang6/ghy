package org.ghy.multiThreadFrame.ch04.ch03_07;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,3,9999,
                TimeUnit.SECONDS,new SynchronousQueue<Runnable>(),new MyThreadFactoryB());
        //RejectedExecutionException并不是执行任务的线程抛出的,在自定义的线程工程里面设置UncaughtExceptionHandler并不能捕获RejectedExecutionException异常
        poolExecutor.execute(new MyRunnable1("中国1"));
        poolExecutor.execute(new MyRunnable1("中国2"));
        poolExecutor.execute(new MyRunnable1("中国3"));
        poolExecutor.execute(new MyRunnable1("中国4"));

    }
}
