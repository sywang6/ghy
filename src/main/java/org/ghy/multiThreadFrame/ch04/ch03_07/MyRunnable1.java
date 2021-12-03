package org.ghy.multiThreadFrame.ch04.ch03_07;

public class MyRunnable1 implements  Runnable{
    private String username;

    public MyRunnable1(String username) {
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
            System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
