package org.ghy.multiThreadFrame.ch07.ch05_01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) {

        try {
            List<Callable<String>> list = new ArrayList<>();
            list.add(new MyCallableA());
            list.add(new MyCallableB());
            ExecutorService executorService = Executors.newCachedThreadPool();
            System.out.println(executorService);
            String getValue = executorService.invokeAny(list);
            System.out.println("返回值 "+getValue);
            System.out.println("mainEND");
        } catch (InterruptedException e) {
            System.out.println("进入catch InterruptedException");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("进入catch ExecutionException");
            e.printStackTrace();
        }

    }
}
