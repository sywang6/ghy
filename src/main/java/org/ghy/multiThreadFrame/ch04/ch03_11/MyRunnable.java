package org.ghy.multiThreadFrame.ch04.ch03_11;

public class MyRunnable implements  Runnable{
    @Override
    public void run() {

        try {
            System.out.println("begin "+System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println("end "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
