package org.ghy.multiThreadFrame.ch07.ch05_01;

import java.util.concurrent.Callable;

public class MyCallableA implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallableA begin "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        for (int i = 0; i < 123; i++) {
            String newString = new String();
            Math.random();
            Math.random();
            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallableA 在运行中"+(i+1));
        }
        System.out.println("MyCallableA end "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        if( 1==1){
            System.out.println("1==1");
            throw new Exception("保存了AAAA");
        }
        return "returnA";
    }
}
