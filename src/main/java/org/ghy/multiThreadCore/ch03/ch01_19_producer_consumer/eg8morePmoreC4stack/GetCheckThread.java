package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg8morePmoreC4stack;

public class GetCheckThread extends  Thread {
private CGetService service;

public GetCheckThread(CGetService service){
    this.service = service;
}
public  void run(){
    service.checkBoxStatus();
}

}
