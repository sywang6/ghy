package org.ghy.multiThreadFrame.ch09.ch09_09;

public class MyRunnable1  implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("begin "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
            Thread.sleep(4000);
            System.out.println(" end "+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
