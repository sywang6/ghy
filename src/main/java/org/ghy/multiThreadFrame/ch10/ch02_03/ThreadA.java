package org.ghy.multiThreadFrame.ch10.ch02_03;

public class ThreadA extends Thread{
    private MyService1 service1;

    public ThreadA(MyService1 service1) {
        this.service1 = service1;
    }
    public void run(){
        try {
            while (!service1.set.isEmpty()){
                Userinfo userInfo = (Userinfo)service1.set.pollFirst();
                System.out.println(userInfo.getId()+" "+userInfo.getUsername());
                Thread.sleep((long)(Math.random()*1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
