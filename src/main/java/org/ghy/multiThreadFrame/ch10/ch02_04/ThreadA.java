package org.ghy.multiThreadFrame.ch10.ch02_04;



public class ThreadA extends  Thread{
    private MyService1 service1;

    public ThreadA(MyService1 service1) {
        this.service1 = service1;
    }
    public void run(){
        for (int i = 0; i < 50; i++) {
            service1.queue.add("threadA"+(i+1));
        }

    }
}
