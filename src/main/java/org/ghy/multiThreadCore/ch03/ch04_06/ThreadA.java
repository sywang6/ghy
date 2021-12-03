package org.ghy.multiThreadCore.ch03.ch04_06;

public class ThreadA extends  Thread{
    public void run(){

        try {
            for (int i = 0; i < 10; i++) {
                UserInfo userInfo = Tools.t1.get();
                System.out.println("在ThreadA线程中取值"+ userInfo.getUsername()+" "+userInfo.hashCode());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
