package org.ghy.multiThreadFrame.ch06.ch05_01;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Run4 {
    public static void main(String[] args) {
        try {
            MyCallableA callableA = new MyCallableA();
            MyCallableB callableB = new MyCallableB();
            Executor executor = Executors.newCachedThreadPool();
            CompletionService completionService = new ExecutorCompletionService(executor);
            completionService.submit(callableA);
            completionService.submit(callableB);
            System.out.println(System.currentTimeMillis());
            System.out.println(System.currentTimeMillis()+" "+completionService.poll(4, TimeUnit.SECONDS));
            System.out.println(System.currentTimeMillis()+"X");
            System.out.println(System.currentTimeMillis()+"  "+completionService.poll(7, TimeUnit.SECONDS).get());


            System.out.println("main end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
