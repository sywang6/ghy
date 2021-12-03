package org.ghy.multiThreadFrame.ch04.ch03_02.eg2_shutsownnow;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable2 myRunnable2 = new MyRunnable2();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,99999,9999, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>()
        );
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        poolExecutor.execute(myRunnable2);
        Thread.sleep(100);
        //一共提交了4个任务,有两个任务正在运行,两个任务在任务队列里面,执行shutdownNow()后,正在执行的任务没有检查中断能正常执行完成
        //还在队列里面的任务被取消
        poolExecutor.shutdownNow();
    }
}
