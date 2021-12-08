package org.ghy.multiThreadFrame.ch09.ch09_09;

import java.io.FileOutputStream;
import java.util.concurrent.ForkJoinPool;

public class Test4 {
    public static void main(String[] args) {
        try {
            MyRunnable1 myRunnable1 = new MyRunnable1();
            ForkJoinPool pool = new ForkJoinPool();
            pool.submit(myRunnable1);
            Thread.sleep(1000);
            //shutdown()不具有中断的效果,这与ThreadPoolExecutor的shutdown()效果类似,只是不能在添加新的任务了,原来的任务还能继续执行
            //,并没有给执行任务的线程设置中断标记
            pool.shutdown();
            if(pool.isShutdown() == false){
                pool.submit(myRunnable1);
            }
            System.out.println("main end!");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
