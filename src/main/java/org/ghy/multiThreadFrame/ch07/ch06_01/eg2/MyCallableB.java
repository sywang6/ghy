package org.ghy.multiThreadFrame.ch07.ch06_01.eg2;

import java.util.concurrent.Callable;

public class MyCallableB implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            System.out.println("MyCallableB begin "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
            for (int i = 0; i < 293456; i++) {
                String newString = new String();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                System.out.println("MyCallableB 在运行中"+(i+1));
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("xxxxxB=中断了");
                    throw new NullPointerException();
                }
            }
            System.out.println("MyCallableB end "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(e.getMessage()+"通过显示try-catch捕获异常了 ");
            throw e;
        }

        return "returnB";
    }
}
