package org.ghy.multiThreadFrame.ch04.ch03_13;

public class MyRunnable implements   Runnable{

    private  String username;

    public MyRunnable(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void run() {

        try {
            System.out.println(Thread.currentThread().getName()+"打印了! beginning "+username+" "+System.currentTimeMillis());
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName()+"打印了! end "+username+" "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
