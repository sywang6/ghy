package org.ghy.multiThreadCore.ch01.ch01_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountOperate extends Thread{

    public CountOperate(){
        System.out.println("CountOperate--begin");
        System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
        System.out.println("this.getName()="+this.getName());
        System.out.println("CountOperate--end");
    }

    public void run(){

        System.out.println("run--begin");
        System.out.println("Thread.currentThread().getName()="+Thread.currentThread().getName());
        System.out.println("this.getName()="+this.getName());
        System.out.println("run--end");
        ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
