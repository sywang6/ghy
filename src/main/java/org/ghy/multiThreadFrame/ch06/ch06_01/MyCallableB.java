package org.ghy.multiThreadFrame.ch06.ch06_01;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallableB begin "+System.currentTimeMillis());
        Thread.sleep(5000);
        int i=0;
        if(i==0){
            throw new Exception("抛出异常");
        }
        System.out.println("MyCallableB end "+System.currentTimeMillis());
        return "returnB";
    }
}
