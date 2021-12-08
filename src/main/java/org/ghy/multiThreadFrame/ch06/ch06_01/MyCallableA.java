package org.ghy.multiThreadFrame.ch06.ch06_01;

import java.util.concurrent.Callable;

public class MyCallableA implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallableA begin "+System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println("MyCallableA end "+System.currentTimeMillis());
        return "returnA";
    }
}
