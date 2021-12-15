package org.ghy.multiThreadFrame.ch10.ch02_05;

public class ThreadB extends Thread{
    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }
    public void run(){
        while (!service.queue.isEmpty()){
            service.queue.pollLast();
            System.out.println(service.queue.size());
        }
    }
}
