package org.ghy.multiThreadFrame.ch04.ch02_01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Run1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Runnable1 begin "+System.currentTimeMillis());
                    System.out.println("A");
                    Thread.sleep(1000);
                    System.out.println("Runnable1 end "+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Runnable2 begin "+System.currentTimeMillis());
                    System.out.println("B");
                    Thread.sleep(1000);
                    System.out.println("Runnable2 end "+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
