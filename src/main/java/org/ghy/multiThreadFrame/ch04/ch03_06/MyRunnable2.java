package org.ghy.multiThreadFrame.ch04.ch03_06;

public class MyRunnable2 implements  Runnable{
    @Override
    public void run() {

            System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
            String abc = null;
            abc.indexOf(0);
            System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());



    }
}
