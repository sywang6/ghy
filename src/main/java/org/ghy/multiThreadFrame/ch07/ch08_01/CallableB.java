package org.ghy.multiThreadFrame.ch07.ch08_01;

import java.util.concurrent.Callable;

public class CallableB implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"MyCallableB begin "+System.currentTimeMillis());
        for (int i = 0; i < 223456; i++) {
            Math.random();
            Math.random();
            Math.random();
            System.out.println("MyCallableB"+(i+1));
        }
        if(1==1){
            System.out.println("B报错了");
            throw new Exception("出现异常");
        }
        System.out.println(Thread.currentThread().getName()+"MyCallableB end"+System.currentTimeMillis());
        return "returnB";
    }
}
