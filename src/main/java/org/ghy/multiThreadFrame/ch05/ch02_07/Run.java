package org.ghy.multiThreadFrame.ch05.ch02_07;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Run {
    public static void main(String[] args) {
        try {
            MyCallable callable = new MyCallable("1");
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            Future<String> future =  executorService.submit(callable);
            //是get方法会抛出异常,并不是submit方法抛出的异常
            String str = future.get();
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
