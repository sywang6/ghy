package org.ghy.multiThreadFrame.ch06.ch05_01;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Run2 {
    public static void main(String[] args) {
        try {
            MyCallableA callableA = new MyCallableA();
            MyCallableB callableB = new MyCallableB();
            Executor executor = Executors.newCachedThreadPool();
            CompletionService completionService = new ExecutorCompletionService(executor);
            completionService.submit(callableA);
            completionService.submit(callableB);
            for (int i = 0; i < 2; i++) {
                System.out.println("zzzzz "+completionService.poll(6, TimeUnit.SECONDS).get());
                System.out.println("X");
            }
            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
