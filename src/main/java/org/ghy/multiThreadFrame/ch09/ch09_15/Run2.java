package org.ghy.multiThreadFrame.ch09.ch09_15;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Run2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyRecursiveTask2 task2 = new MyRecursiveTask2(1,900000);
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(task2);
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
        }while (!task2.isDone());
        System.out.println(task2.get());
    }
}
