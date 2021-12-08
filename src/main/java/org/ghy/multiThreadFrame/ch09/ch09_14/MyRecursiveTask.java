package org.ghy.multiThreadFrame.ch09.ch09_14;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<String> {
    private static final long serialVersionUID = -500102803837868651L;

    @Override
    protected String compute() {
        return "我是返回值";
    }
}
