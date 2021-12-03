package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg8morePmoreC4stack;

public class SetCheckThread extends Thread{
    private PSetService service;
    public SetCheckThread(PSetService service){
        this.service = service;
    }
    public void run(){
        service.checkBoxStatus();
    }
}
