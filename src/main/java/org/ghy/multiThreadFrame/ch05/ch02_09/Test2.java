package org.ghy.multiThreadFrame.ch05.ch02_09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test2 {
    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(50,Integer.MAX_VALUE,
                5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        try {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Integer.parseInt("a");
                }
            });
        }catch (Exception e){
            System.out.println("ex");
            e.printStackTrace();
        }
    }
}
