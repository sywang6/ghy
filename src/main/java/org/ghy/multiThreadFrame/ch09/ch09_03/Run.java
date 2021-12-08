package org.ghy.multiThreadFrame.ch09.ch09_03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Run {
    public static void main(String[] args) {

        try {
            MyRecursiveTask task = new MyRecursiveTask();
            ForkJoinPool pool = new ForkJoinPool();
            pool.execute(task);
            System.out.println(System.currentTimeMillis());
            System.out.println(task.get());
            System.out.println(System.currentTimeMillis());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
