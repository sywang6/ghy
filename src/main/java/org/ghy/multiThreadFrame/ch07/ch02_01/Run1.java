package org.ghy.multiThreadFrame.ch07.ch02_01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run1 {
    public static void main(String[] args) {

        try {
            List<Callable<String>> list = new ArrayList<>();
            list.add(new MyCallableA());
            list.add(new MyCallableB1());

            ExecutorService executorService = Executors.newCachedThreadPool();
            String getvalueA = executorService.invokeAny(list);
            System.out.println("===="+getvalueA);
            System.out.println("zzzzzzz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
