package org.ghy.multiThreadFrame.ch10.ch02_05;

public class ThreadA extends  Thread {

    private MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }
    public void run(){
        while (!service.queue.isEmpty()){
            service.queue.pollFirst();
            System.out.println(service.queue.size());
        }
    }


}
