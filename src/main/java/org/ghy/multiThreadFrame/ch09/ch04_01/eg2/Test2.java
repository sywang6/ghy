package org.ghy.multiThreadFrame.ch09.ch04_01.eg2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Test2 {
    public static void main(String[] args) {
            MyRecursiveTask task1 = new MyRecursiveTask();
            ForkJoinPool pool = new ForkJoinPool();
            ForkJoinTask task2 = pool.submit(task1);
            //join方法没有声明抛出异常,但是任务运行异常会直接抛出来
            System.out.println(task2.join());
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                String newString = new String();
                for (int j = 0; j < 10; j++) {
                    Math.random();
                }
            }
            System.out.println("main end");
    }
}
