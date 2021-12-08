package org.ghy.multiThreadFrame.ch07.ch10_01;

import java.util.concurrent.Callable;

public class CallableA implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"MyCallableA begin "+System.currentTimeMillis());
        for (int i = 0; i < 223456; i++) {
            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallableA"+(i+1));
        }
        System.out.println(Thread.currentThread().getName()+"MyCallableA end"+System.currentTimeMillis());
        return "MyCallableAValue";
    }
}
