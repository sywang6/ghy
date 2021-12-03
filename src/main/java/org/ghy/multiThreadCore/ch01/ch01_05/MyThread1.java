package org.ghy.multiThreadCore.ch01.ch01_05;

public class MyThread1 extends Thread{


    public void run(){

        try {
            System.out.println(Thread.currentThread().getName()+" begin");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" end");
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
