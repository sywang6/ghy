package org.ghy.multiThreadFrame.ch09.ch08_01;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Run {
    public static void main(String[] args) {
        try {
            MyRecursiveTask task = new MyRecursiveTask(1,10);
            ForkJoinPool pool = new ForkJoinPool();
            System.out.println("结果值为: "+pool.submit(task).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
