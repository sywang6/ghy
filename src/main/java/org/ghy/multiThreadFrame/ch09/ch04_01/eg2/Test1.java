package org.ghy.multiThreadFrame.ch09.ch04_01.eg2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Test1 {
    public static void main(String[] args) {
        try {
            MyRecursiveTask task1 = new MyRecursiveTask();
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask task2 = pool.submit(task1);
            //get()方法声明抛出了异常,需要捕获处理,或者继续向外抛
            System.out.println(task2.get());
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                String newString = new String();
                for (int j = 0; j < 10; j++) {
                    Math.random();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
