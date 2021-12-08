package org.ghy.multiThreadFrame.ch09.ch09_13;

public class MyRunnable2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
