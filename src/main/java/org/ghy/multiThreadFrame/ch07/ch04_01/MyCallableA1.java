package org.ghy.multiThreadFrame.ch07.ch04_01;

import java.util.concurrent.Callable;

public class MyCallableA1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            System.out.println("MyCallableA begin "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
            for (int i = 0; i < 123456; i++) {
                String newString = new String();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                System.out.println("MyCallableA 在运行中"+(i+1));
            }
            if( 1==1){
                System.out.println("xxxxx=中断了");
                throw new NullPointerException();
            }

            System.out.println("MyCallableA end "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
            //throw e;
        }
        return "returnA";
    }
}
