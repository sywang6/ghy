package org.ghy.multiThreadFrame.ch09.ch09_15;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Run3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyRecursiveTask3 task3 = new MyRecursiveTask3(1,900000);
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(task3);
        do{
            System.out.println(
                    " getParallelism:"+pool.getParallelism()+
                    " getPoolSize:"+pool.getPoolSize()+
                    " getActiveThreadCount:"+pool.getActiveThreadCount()+
                    " getQueuedSubmissionCount:"+pool.getQueuedSubmissionCount()+
                    " getStealCount:"+pool.getStealCount()+
                    " getQueuedSubmissionCount:"+pool.getQueuedSubmissionCount()+
                    " getRunningThreadCount:"+pool.getRunningThreadCount()
            );
        }while (!task3.isDone());
        System.out.println(task3.get());
    }
}
