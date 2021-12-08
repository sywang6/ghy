package org.ghy.multiThreadFrame.ch09.ch09_01;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private static final long serialVersionUID = -1671763463442890407L;

    @Override
    protected void compute() {
        try {
            System.out.println("Thread="+Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Thread end="+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
