package org.ghy.multiThreadFrame.ch02.ch02_03;

public class ThreadA extends Thread{

    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }
    public void run(){
        service.beginRun();
    }
}
