package org.ghy.multiThreadFrame.ch09.ch04_01.eg1;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = -1494002961050744846L;

    @Override
    protected Integer compute() {
        System.out.println("compute time="+System.currentTimeMillis());
        return 100;
    }
}
