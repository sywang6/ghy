package org.ghy.multiThreadFrame.ch09.ch09_14;

import java.util.concurrent.ForkJoinPool;

public class Test1 {
    public static void main(String[] args) {
        MyRecursiveAction action = new MyRecursiveAction();
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(action);
    }
}
