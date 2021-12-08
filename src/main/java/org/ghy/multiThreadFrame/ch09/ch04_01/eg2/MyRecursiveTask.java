package org.ghy.multiThreadFrame.ch09.ch04_01.eg2;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 8749631038575647166L;

    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread().getName()+"执行compute方法");
        String nullString = null;
        nullString.toString();
        return 100;
    }
}
