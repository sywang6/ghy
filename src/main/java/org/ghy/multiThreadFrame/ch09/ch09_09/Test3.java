package org.ghy.multiThreadFrame.ch09.ch09_09;

import java.util.concurrent.ForkJoinPool;

public class Test3 {
    public static void main(String[] args) {
        try {
            MyRunnable1 myRunnable1 = new MyRunnable1();
            ForkJoinPool pool = new ForkJoinPool();
            pool.submit(myRunnable1);
            pool.submit(myRunnable1);
            pool.submit(myRunnable1);
            pool.shutdown();
            //shutdown()不具有中断的效果,这与ThreadPoolExecutor的shutdown()效果类似,只是不能在添加新的任务了,原来的任务还能继续执行
            //,并没有给执行任务的线程设置中断标记.  但是关闭后在提交任务与ThreadPoolExecutor表现不一致, ThreadPoolExecutor shutdown
            //后在提交任务不影响原有任务的执行,而ForkJoinPool会影响,导致前面提交的任务也不能执行了
            pool.submit(myRunnable1);
            System.out.println("main end");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
