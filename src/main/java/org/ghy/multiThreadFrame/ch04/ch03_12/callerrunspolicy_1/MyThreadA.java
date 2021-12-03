package org.ghy.multiThreadFrame.ch04.ch03_12.callerrunspolicy_1;

public class MyThreadA extends Thread {
    public void run(){
        try {
            Thread.sleep(5000);
            System.out.println(" end "+Thread.currentThread().getName()+" "+System.currentTimeMillis() );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
