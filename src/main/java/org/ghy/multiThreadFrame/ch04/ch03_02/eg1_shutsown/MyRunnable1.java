package org.ghy.multiThreadFrame.ch04.ch03_02.eg1_shutsown;

public class MyRunnable1 implements  Runnable{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
