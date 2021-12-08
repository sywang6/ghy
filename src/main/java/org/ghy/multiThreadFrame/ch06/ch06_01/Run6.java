package org.ghy.multiThreadFrame.ch06.ch06_01;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;

public class Run6 {
    public static void main(String[] args) {
        try {
            MyCallableA callableA = new MyCallableA();
            MyCallableB callableB = new MyCallableB();
            Executor executor = Executors.newSingleThreadExecutor();
            CompletionService completionService = new ExecutorCompletionService(executor);
            completionService.submit(callableB);//单线程的线程池,先执行B在执行A
            completionService.submit(callableA);
            for (int i = 0; i < 2; i++) {
                System.out.println("zzzzz"+completionService.poll());
            }
            Thread.sleep(8000);
            System.out.println("A处"+" "+completionService.poll().get());
            System.out.println("B处"+" "+completionService.poll().get());
            System.out.println("main end");
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("main ex");
            e.printStackTrace();
        }
    }
}
