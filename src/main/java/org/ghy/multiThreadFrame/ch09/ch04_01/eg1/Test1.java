package org.ghy.multiThreadFrame.ch09.ch04_01.eg1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Test1 {
    public static void main(String[] args) {
        try {
            MyRecursiveTask task1 = new MyRecursiveTask();
            System.out.println(task1.hashCode());
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask task2 = pool.submit(task1);
            System.out.println(task2.hashCode()+" "+task2.get());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
