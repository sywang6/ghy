package org.ghy.multiThreadFrame.ch01.ch01_15;

public class ThreadP extends  Thread{

    private RepastService service;

    public ThreadP(RepastService service) {
        this.service = service;
    }
    public void run(){
        service.set();
    }
}
