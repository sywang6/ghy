package org.ghy.multiThreadFrame.ch05.ch02_05.eg5;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            int i= 0;
            while (1 ==1 ){
                if(Thread.currentThread().isInterrupted()){
                    throw new InterruptedException();
                }
                i++;
                System.out.println(Thread.currentThread().getName()+" ");
                Math.random();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "我的年龄是100";
    }
}
