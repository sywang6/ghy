package org.ghy.multiThreadFrame.ch09.ch05_01;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTaskA extends RecursiveTask<Integer> {
    private static final long serialVersionUID = 1155412195842495699L;

    @Override
    protected Integer compute() {
        try {
            System.out.println(Thread.currentThread().getName()+" begin A "+System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+" end A "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 100;
    }
}
