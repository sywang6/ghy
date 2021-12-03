package org.ghy.multiThreadFrame.ch06.ch03_01;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            CompletionService completionService = new ExecutorCompletionService(executorService);
            for (int i = 0; i < 10; i++) {
                completionService.submit(new Callable() {
                    @Override
                    public Object call() throws Exception {
                    long sleepValue = (int)(Math.random()*1000);
                    System.out.println("sleep="+sleepValue+" "+Thread.currentThread().getName());
                    Thread.sleep(sleepValue);
                        return "高洪岩"+sleepValue+" "+Thread.currentThread().getName();
                    }
                });
            }
            for (int i = 0; i < 10; i++) {
                //CompletionService包装了executorService,take()实现了先完成的任务优先返回
                System.out.println(completionService.take().get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}





















