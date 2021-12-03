package org.ghy.multiThreadFrame.ch02.ch02_07;

public class ThreadA  extends Thread{
    private MyService myService;

    public ThreadA(MyService myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.testMethod();
    }
}
