package org.ghy.multiThreadFrame.ch06.ch06_01;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class Run1 {
    public static void main(String[] args) {
        try {
            MyCallableA callableA = new MyCallableA();
            MyCallableB callableB = new MyCallableB();
            Executor executor = Executors.newSingleThreadExecutor();
            CompletionService completionService = new ExecutorCompletionService(executor);
            completionService.submit(callableA);
            completionService.submit(callableB);
            for (int i = 0; i < 2; i++) {
                System.out.println("zzzzz"+completionService.take());
            }
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
