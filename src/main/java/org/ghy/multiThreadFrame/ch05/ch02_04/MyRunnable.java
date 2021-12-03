package org.ghy.multiThreadFrame.ch05.ch02_04;

public class MyRunnable implements  Runnable{

    private Userinfo userinfo;

    public MyRunnable(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public void run() {
        userinfo.setUsername("usernameValue");
        userinfo.setPassword("passwordValue");
    }
}
