package org.ghy.multiThreadCore.ch01.ch01_11.ch07;

public class MyThreadA extends Thread{

    private MyService myService;

    public MyThreadA(MyService myService){
        this.myService = myService;
    }

    public void run(){
        myService.printString("b","bb");
    }
}
