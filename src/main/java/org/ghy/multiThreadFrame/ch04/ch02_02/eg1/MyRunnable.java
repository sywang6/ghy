package org.ghy.multiThreadFrame.ch04.ch02_02.eg1;

public class MyRunnable implements  Runnable{

    private String userName;

    public MyRunnable(String userName) {
        this.userName = userName;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+" userName="+userName+" begin "+System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" userName="+userName+" end "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
