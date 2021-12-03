package org.ghy.multiThreadFrame.ch01.ch01_15;

public class ThreadC extends  Thread{

    private RepastService service;

    public ThreadC(RepastService service) {
        this.service = service;
    }
    public void run(){
        service.get();
    }
}
