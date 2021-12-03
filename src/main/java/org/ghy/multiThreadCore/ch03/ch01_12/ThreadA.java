package org.ghy.multiThreadCore.ch03.ch01_12;

public class ThreadA extends  Thread{

    private Object lock;

    public ThreadA(Object lock){
        this.lock = lock;
    }

    public void run(){
        Service service = new Service();
        service.testMethod(lock);
    }
}
