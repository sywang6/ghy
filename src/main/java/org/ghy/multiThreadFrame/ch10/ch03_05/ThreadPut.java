package org.ghy.multiThreadFrame.ch10.ch03_05;

public class ThreadPut extends  Thread {
    private  MyService service;

    public ThreadPut(MyService service) {
        this.service = service;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            service.putMethod();
        }
    }
}
