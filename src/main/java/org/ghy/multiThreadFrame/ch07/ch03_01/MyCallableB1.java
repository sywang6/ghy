package org.ghy.multiThreadFrame.ch07.ch03_01;

import java.util.concurrent.Callable;

public class MyCallableB1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            System.out.println("MyCallableB begin "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
            for (int i = 0; i < 193456; i++) {
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                Math.random();
                System.out.println("MyCallableB 在运行中"+(i+1));
            }
            if(1 ==1 ){
                System.out.println("xxxxx=中断了");
                throw new NullPointerException();
            }
            System.out.println("MyCallableB end "+Thread.currentThread().getName()+"  "+System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage()+" 通过显示try-catch捕获异常了 ");
        }
        return "returnB";
    }
}
