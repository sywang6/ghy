package org.ghy.multiThreadFrame.ch09.ch09_06;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "我是返回值callableVersion";
    }
}
