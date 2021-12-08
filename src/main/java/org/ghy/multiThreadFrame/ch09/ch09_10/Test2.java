package org.ghy.multiThreadFrame.ch09.ch09_10;

import java.util.concurrent.ForkJoinPool;

public class Test2  {
    public static void main(String[] args) {
        try {
            MyRunnable2 myRunnable2 = new MyRunnable2();
            ForkJoinPool pool = new ForkJoinPool();
            pool.execute(myRunnable2);
            Thread.sleep(1000);
            pool.shutdownNow();
            System.out.println("main end!");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //shutdown:
        //每个任务正常运行直到结束
        //池关闭后不再允许有新任务被执行并抛出RejectExecutionException异常

        //shutdownNow结合isInterrupted()==true判断:
        //立即停止当前正在执行的任务
        //池关闭后不再允许有新任务被执行并抛出RejectExecutionException异常

        //shutdownNow未结合isInterrupted()==true判断:
        //每个任务正常运行直到结束
        //池关闭后不再允许有新任务被执行并抛出RejectExecutionException异常
    }
}
