package org.ghy.multiThreadFrame.ch09.ch09_14;

import java.util.concurrent.ForkJoinPool;

public class Test2 {
    public static void main(String[] args) {
        MyRecursiveTask action = new MyRecursiveTask();
        ForkJoinPool pool = new ForkJoinPool();
        String returnString =  pool.invoke(action);
        System.out.println(returnString);
    }
}
