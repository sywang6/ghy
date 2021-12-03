package org.ghy.multiThreadFrame.ch04.ch02_02.eg2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable(""+(i+1)));
        }
        System.out.println();
        System.out.println();
        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable(""+(i+1)));
        }
    }
}
