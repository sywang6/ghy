package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg8morePmoreC4stack;

public class GetValueThread extends  Thread{

    private CGetService service;

    public GetValueThread(CGetService service){
        this.service = service;
    }

    public void run(){
        while (true){
            service.getMethod();
        }
    }

}
