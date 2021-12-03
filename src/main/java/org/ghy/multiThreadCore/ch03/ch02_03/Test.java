package org.ghy.multiThreadCore.ch03.ch02_03;

public class Test {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            System.out.println("main begin time="+System.currentTimeMillis());
            myThread.join(2000);
            System.out.println("main end time="+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
