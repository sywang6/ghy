package org.ghy.multiThreadFrame.ch09.ch09_10;

import jdk.nashorn.internal.codegen.FieldObjectCreator;

import java.util.concurrent.ForkJoinPool;

public class Test0 {
    public static void main(String[] args) throws InterruptedException {
        MyRunnable1 myRunnable1 = new MyRunnable1();
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(myRunnable1);
        Thread.sleep(2000);
        //shutdownNow设置了中断标记,myRunnable1检查了中断标记
        pool.shutdownNow();
        System.out.println("main end");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
