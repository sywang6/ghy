package org.ghy.multiThreadFrame.ch04.ch03_13;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected  void afterExecute(Runnable r,Throwable t){
        super.afterExecute(r,t);
        System.out.println(((MyRunnable)r).getUsername()+" 执行完了 ");
    }

    @Override
    protected  void beforeExecute(Thread t,Runnable r){
        super.beforeExecute(t,r);
        System.out.println(Thread.currentThread().getName()+" "+((MyRunnable)r).getUsername()+" 准备执行 ");
    }
}
