package org.ghy.multiThreadFrame.ch04.ch03_15;

import org.ghy.multiThreadFrame.ch01.ch01_15.ThreadP;
import org.ghy.multiThreadFrame.ch02.ch02_04.MyThread;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GetActiveCount_test1 {
    public static void main(String[] args) {

        try {
            MyThreadA a = new MyThreadA();
            SynchronousQueue queue = new SynchronousQueue();
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,5,5, TimeUnit.SECONDS,queue);
            poolExecutor.execute(a);
            poolExecutor.execute(a);
            poolExecutor.execute(a);
            System.out.println(poolExecutor.getActiveCount()+" "+poolExecutor.getPoolSize());
            Thread.sleep(7000);
            //7秒过后任务都执行完成了,非核心线程还没有回收
            System.out.println(poolExecutor.getActiveCount()+" "+poolExecutor.getPoolSize());
            Thread.sleep(7000);
            //在过7秒,非核心线程回收了
            System.out.println(poolExecutor.getActiveCount()+" "+poolExecutor.getPoolSize());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
