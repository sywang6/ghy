package org.ghy.multiThreadFrame.ch01.ch01_07;



public class MyThread extends  Thread{

    private MyService service;

    public MyThread(MyService service) {
        this.service = service;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+"启动了");
        service.testMethod();
    }
}
