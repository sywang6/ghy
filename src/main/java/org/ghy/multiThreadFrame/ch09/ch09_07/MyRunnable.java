package org.ghy.multiThreadFrame.ch09.ch09_07;

public class MyRunnable implements  Runnable{

    private  Userinfo   userinfo;

    public MyRunnable(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    @Override
    public void run() {
        try {
            userinfo.setUsername("设置的值");
            System.out.println("已经设置完结!");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
