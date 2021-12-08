package org.ghy.multiThreadFrame.ch09.ch09_04;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<String> {
    private static final long serialVersionUID = 6724277567058625184L;

    @Override
    protected String compute() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "我是返回值";
    }
}
