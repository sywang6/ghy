package org.ghy.multiThreadFrame.ch06.ch05_01;

import java.util.concurrent.Callable;

public class MyCallableA implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        System.out.println("MyCallableA "+System.currentTimeMillis());
        return "returnA";
    }
}
