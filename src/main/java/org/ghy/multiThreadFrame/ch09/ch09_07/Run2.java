package org.ghy.multiThreadFrame.ch09.ch09_07;

import java.util.concurrent.ForkJoinPool;

public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        Userinfo userinfo = new Userinfo();
        MyRunnable runnable = new MyRunnable(userinfo);
        ForkJoinPool pool = new ForkJoinPool();
        Thread.sleep(2000);
        pool.submit(runnable,userinfo);
        System.out.println("userinfo username="+userinfo.getUsername());
        Thread.sleep(2000);
    }
}
