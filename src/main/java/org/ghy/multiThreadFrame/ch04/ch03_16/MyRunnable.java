package org.ghy.multiThreadFrame.ch04.ch03_16;

public class MyRunnable implements  Runnable{
    private String username;

    public MyRunnable(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        System.out.println(username);
    }
}
