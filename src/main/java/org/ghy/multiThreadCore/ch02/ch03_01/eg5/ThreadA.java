package org.ghy.multiThreadCore.ch02.ch03_01.eg5;

public class ThreadA extends Thread{

    private  Service service;

    public ThreadA(Service service){
        this.service = service;
    }
    public void run(){
        service.runMethod();
    }
}
