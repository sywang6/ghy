package org.ghy.multiThreadFrame.ch04.ch02_06;

import org.ghy.multiThreadFrame.ch04.ch02_02.eg2.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable(""+(i+1)));
        }
    }
}
