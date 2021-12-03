package org.ghy.multiThreadCore.ch02.ch03_01.eg5;

public class ThreadB extends  Thread{
    private Service service;
    public ThreadB(Service service){
        this.service = service;
    }
    public void run(){
        service.stopMethod();
    }
}
