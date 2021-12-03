package org.ghy.multiThreadFrame.ch01.ch01_04.eg1;

public class ThreadA extends Thread{
    private  Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    public void run(){
        service.testMethod();
    }
}
