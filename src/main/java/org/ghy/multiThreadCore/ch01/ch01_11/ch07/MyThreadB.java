package org.ghy.multiThreadCore.ch01.ch01_11.ch07;

public class MyThreadB extends  Thread{

    private MyService myService;

    public MyThreadB(MyService myService){
        this.myService = myService;
    }


    public void run(){
        System.out.println("username:"+myService.getUsername());
        System.out.println("password:"+myService.getPassword());

    }

}
