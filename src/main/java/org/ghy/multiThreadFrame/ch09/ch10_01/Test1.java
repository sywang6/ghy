package org.ghy.multiThreadFrame.ch09.ch10_01;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {

        MyRecursiveTask myRecursiveTask = new MyRecursiveTask();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask task = pool.submit(myRecursiveTask);
        System.out.println(task.isCompletedAbnormally()+" "+task.isCompletedNormally());
        Thread.sleep(2000);
        System.out.println(task.isCompletedAbnormally()+" "+task.isCompletedNormally());
        System.out.println(task.getException());
    }
}
