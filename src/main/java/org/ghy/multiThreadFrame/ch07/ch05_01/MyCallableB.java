package org.ghy.multiThreadFrame.ch07.ch05_01;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallableB begin "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        for (int i = 0; i < 123456; i++) {
            String newString = new String();
            Math.random();
            Math.random();
            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallableB 在运行中"+(i+1));
        }
        System.out.println("MyCallableB end "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        if( 1==1){
            System.out.println("1==1");
            throw new Exception("保存了BBBB");
        }
        return "returnB";
    }
}
