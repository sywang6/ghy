package org.ghy.multiThreadFrame.ch02.ch02_05;

public class MythreadA extends  Thread{

    private MyService service;

    public MythreadA(MyService service) {
        this.service = service;
    }
    public  void run(){
        service.testMethod();
    }
}
