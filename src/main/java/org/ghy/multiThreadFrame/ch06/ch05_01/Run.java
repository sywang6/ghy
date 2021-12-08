package org.ghy.multiThreadFrame.ch06.ch05_01;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) {
        MyCallableA callableA = new MyCallableA();
        MyCallableB callableB = new MyCallableB();
        Executor executor = Executors.newCachedThreadPool();
        CompletionService completionService = new ExecutorCompletionService(executor);
        completionService.submit(callableA);
        completionService.submit(callableB);
        for (int i = 0; i < 2; i++) {
            System.out.println("zzzzz "+completionService.poll());
        }
        System.out.println("main end");
    }
}
