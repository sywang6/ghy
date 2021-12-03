package org.ghy.multiThreadFrame.ch05.ch02_05.eg4;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        int i = 0;
        while (i==0){
            System.out.println("zzzzzzzzzzz");
        }
        return "我的年龄是100";
    }
}
