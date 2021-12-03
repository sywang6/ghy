package org.ghy.multiThreadCore.ch03.ch04_05;

public class ThreadA extends  Thread{
    public void run(){

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("在ThreadA线程中取值"+ Tools.t1.get());
                Thread.sleep(1000);
                if(i==5){
                    Tools.t1.set("我是ThreadA的newnew最新的值!");
                    System.out.println("ThreadA已存在最新的值----");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
