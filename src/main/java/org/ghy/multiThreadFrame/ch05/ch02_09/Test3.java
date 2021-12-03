package org.ghy.multiThreadFrame.ch05.ch02_09;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test3 {
    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(50,Integer.MAX_VALUE,
                5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        try {
          Future future =   executorService.submit(new Callable<String>() {
                @Override
                public String call() {
                    System.out.println("call");
                    //把异常信息放到结果里面了, future.get()会抛出异常
                    Integer.parseInt("a");
                    return "我是返回值";
                }
            });
          System.out.println(future.get());
        }catch (Exception e){
            System.out.println("ex");
            e.printStackTrace();
        }
    }
}
