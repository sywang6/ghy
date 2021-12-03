package org.ghy.multiThreadFrame.ch04.ch02_02.eg1;

import org.ghy.multiThreadFrame.ch04.ch02_02.eg1.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyRunnable(""+(i+1)));
        }
    }
}
