package org.ghy.multiThreadFrame.ch05.ch02_05.eg2;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "我的年龄是100";
    }
}
