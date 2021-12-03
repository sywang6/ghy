package org.ghy.multiThreadFrame.ch05.ch02_06;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        System.out.println("sleep 10秒执行完了");
        return "anyString";
    }
}
