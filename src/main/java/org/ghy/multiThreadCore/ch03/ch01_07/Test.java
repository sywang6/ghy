package org.ghy.multiThreadCore.ch03.ch01_07;

public class Test {

    public static void main(String[] args) throws InterruptedException {
       final MyService myService = new MyService();
        Thread  threadA = new Thread(){
            public void run(){
                myService.waitMethod();
            }
        };
        Thread  threadB = new Thread(){
            public void run(){
                myService.notifyMethod();
            }
        };
        threadA.start();
        Thread.sleep(1000);
        threadB.start();

    }
}
