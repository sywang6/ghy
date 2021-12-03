package org.ghy.multiThreadFrame.ch05.ch02_02;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run {
    public static void main(String[] args) {
        try {
            MyCallable callable = new MyCallable(100);
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,5,
                    TimeUnit.SECONDS,new LinkedBlockingDeque<>());
            Future<String> future = executor.submit(callable);
            System.out.println("main A "+System.currentTimeMillis());
            System.out.println(future.get());
            System.out.println("main B "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
