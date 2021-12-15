package org.ghy.multiThreadFrame.ch10.ch02_06;

public class ThreadA extends Thread{
    private  MyServiceA serviceA;

    public ThreadA(MyServiceA serviceA) {
        this.serviceA = serviceA;
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            MyServiceA.list.add("anyString");
        }
    }
}
