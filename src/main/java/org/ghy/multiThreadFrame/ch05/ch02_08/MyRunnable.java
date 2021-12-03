package org.ghy.multiThreadFrame.ch05.ch02_08;

public class MyRunnable implements  Runnable{

    private String username;

    public MyRunnable(String username) {
        this.username = username;
    }

    @Override
    public void run() {
        System.out.println(username+" 在运行! ");
    }
}
