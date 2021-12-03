package org.ghy.multiThreadFrame.ch02.ch01_03;

public class MyThread extends  Thread{
    private  MyService myService;

    public MyThread(MyService myService) {
        this.myService = myService;
    }
    public void run(){
        myService.testMethod();
    }
}
