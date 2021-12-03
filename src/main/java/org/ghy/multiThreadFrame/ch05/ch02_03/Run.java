package org.ghy.multiThreadFrame.ch05.ch02_03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Run {
    public static void main(String[] args) {
        try {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("打印的信息");
                }
            };
            ExecutorService executorService = Executors.newCachedThreadPool();
            Future future = executorService.submit(runnable);
            System.out.println(future.get()+" "+future.isDone() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
