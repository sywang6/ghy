package org.ghy.multiThreadFrame.ch10.ch02_06;

public class ThreadB extends Thread{
    private  MyServiceB serviceB;

    public ThreadB(MyServiceB serviceB) {
        this.serviceB = serviceB;
    }
    public void run(){
        for (int i = 0; i < 100; i++) {
            MyServiceB.list.add("anyString");
        }
    }
}
