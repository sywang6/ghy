package org.ghy.multiThreadFrame.ch07.ch09_01;

import java.util.concurrent.Callable;

public class CallableA implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"MyCallableA begin "+System.currentTimeMillis());
        for (int i = 0; i < 123; i++) {
            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallableA"+(i+1));
        }
        System.out.println(Thread.currentThread().getName()+"MyCallableA end"+System.currentTimeMillis());
       if(1==1){
           System.out.println("A报错了");
           throw  new Exception("出现异常");
       }
        return "returnA";
    }
}
