package org.ghy.multiThreadFrame.ch10.ch03_07.eg4;


public class ThreadB1 extends Thread{
    private MyServiceB service;

    public ThreadB1(MyServiceB service) {
        this.service = service;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName()+" beginA "+System.currentTimeMillis());
        System.out.println("tryTransfer(e)返回值为: "+service.queue.tryTransfer("我是数据"));
        System.out.println(Thread.currentThread().getName()+" endA "+System.currentTimeMillis());
    }
}
