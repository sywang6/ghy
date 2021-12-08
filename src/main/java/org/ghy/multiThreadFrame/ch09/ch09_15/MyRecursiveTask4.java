package org.ghy.multiThreadFrame.ch09.ch09_15;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveTask4 extends RecursiveAction {
    private static final long serialVersionUID = -2797313863678859132L;
    private int i = 0;
    @Override
    protected void compute() {
        System.out.println("beginA="+Thread.currentThread().getName());
        while (i<100000){
            String newString = new String();
            for (int j = 0; j < 6; j++) {
                Math.random();
            }
        }
        System.out.println("endA="+Thread.currentThread().getName());
    }
}
