package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg8morePmoreC4stack;

public class SetValueThread extends Thread{

    private PSetService service;

    public SetValueThread(PSetService service){
        this.service = service;
    }

    public void run(){
        while (true){
            service.setMethmod();
        }
    }
}
