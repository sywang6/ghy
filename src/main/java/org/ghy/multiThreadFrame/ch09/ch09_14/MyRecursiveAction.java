package org.ghy.multiThreadFrame.ch09.ch09_14;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {
    private static final long serialVersionUID = -7847273004121889986L;

    @Override
    protected void compute() {
        System.out.println("ThreadName="+Thread.currentThread().getName());
    }
}
