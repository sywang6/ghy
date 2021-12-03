package org.ghy.multiThreadCore.ch01.ch01_03;

public class MyThread extends Thread{

    public MyThread(){
        System.out.println("构造方法打印:"+Thread.currentThread().getName());
    }

    public void run(){
        System.out.println("run方法打印:"+Thread.currentThread().getName());
    }

}
