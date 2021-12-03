package org.ghy.multiThreadCore.ch03.ch01_16;

public class MyThreadA extends Thread{
    private MyService service;
    public MyThreadA(MyService service){
        this.service = service;
    }
    public void run(){
        service.testMethod();
    }
}
