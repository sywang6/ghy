package org.ghy.multiThreadFrame.ch10.ch02_04;

public class ThreadB extends  Thread{
    private MyService1 service1;

    public ThreadB(MyService1 service1) {
        this.service1 = service1;
    }

    public void run(){
        for (int i = 0; i < 50; i++) {
            service1.queue.add("threadB"+(i+1));
        }
    }
}
