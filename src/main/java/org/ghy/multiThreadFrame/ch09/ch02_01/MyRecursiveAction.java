package org.ghy.multiThreadFrame.ch09.ch02_01;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private static final long serialVersionUID = -3732666538133303951L;

    @Override
    protected void compute() {
        System.out.println("compute run!");
    }
}
