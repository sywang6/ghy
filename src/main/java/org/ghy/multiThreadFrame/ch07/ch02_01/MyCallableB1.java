package org.ghy.multiThreadFrame.ch07.ch02_01;

import java.util.concurrent.Callable;

public class MyCallableB1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallableB1 begin "+System.currentTimeMillis());
        for (int i = 0; i < 223456; i++) {
            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallableB1 "+(i+1));
        }
        System.out.println("MyCallableB1 end "+System.currentTimeMillis());
        return "returnB1";
    }
}
