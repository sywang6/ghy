package org.ghy.multiThreadFrame.ch09.ch09_15;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveTask1 extends RecursiveAction {
    private static final long serialVersionUID = -2662462204950339963L;

    @Override
    protected void compute() {

        try {
            System.out.println("begin="+Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println(" end="+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
