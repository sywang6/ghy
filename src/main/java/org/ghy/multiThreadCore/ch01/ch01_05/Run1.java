package org.ghy.multiThreadCore.ch01.ch01_05;

public class Run1 {

    public static void main(String[] args){
        MyThread1 mythread = new MyThread1();
        System.out.println("begin="+System.currentTimeMillis());
        mythread.run();
        System.out.println("end = "+System.currentTimeMillis());

    }

}
