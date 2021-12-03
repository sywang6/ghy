package org.ghy.multiThreadFrame.ch05.ch02_05.eg3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {

        int i = 0;
        while (i == 0){
            if(Thread.currentThread().isInterrupted()){
                throw new InterruptedException();
            }
            System.out.println("证在运行中");
        }

        return "我的年龄是100";
    }
}
