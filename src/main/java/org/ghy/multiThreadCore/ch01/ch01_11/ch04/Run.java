package org.ghy.multiThreadCore.ch01.ch01_11.ch04;

public class Run {

    public static void main(String[] args){


        MyThread myThread = new MyThread();
        myThread.notify();
        myThread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //先执行sleep,在中断线程
        myThread.interrupt();


    }

}
