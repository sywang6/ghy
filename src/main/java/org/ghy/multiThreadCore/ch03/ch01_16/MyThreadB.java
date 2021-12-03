package org.ghy.multiThreadCore.ch03.ch01_16;

public class MyThreadB extends Thread{
    private MyService service;
    public MyThreadB(MyService service){
        this.service = service;
    }
    public void run(){
        service.longTimeSyn();
    }
}
