package org.ghy.multiThreadFrame.ch06.ch07_01;

public class MyRunnable implements Runnable{

    private  UserInfo userInfo;

    public MyRunnable(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userInfo.setUsername("usernameValue");
        userInfo.setPassword("passwordValue");
        System.out.println("run运行了");
    }
}
