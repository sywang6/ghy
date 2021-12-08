package org.ghy.multiThreadFrame.ch09.ch09_07;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Run3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Userinfo userinfo = new Userinfo();
        MyRunnable runnable = new MyRunnable(userinfo);
        ForkJoinPool pool = new ForkJoinPool();
        Future<Userinfo> future =  pool.submit(runnable,userinfo);
        System.out.println(future);
        System.out.println("userinfo username="+future.get().getUsername());

    }
}
