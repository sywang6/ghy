package org.ghy.multiThreadFrame.ch01.ch01_13;

public class MyThread  extends  Thread {
    private Service service;

    public MyThread(Service service) {
        this.service = service;
    }
    public  void run(){
        service.sayHello();
    }
}
