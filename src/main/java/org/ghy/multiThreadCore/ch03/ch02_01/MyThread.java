package org.ghy.multiThreadCore.ch03.ch02_01;

public class MyThread extends  Thread{

    public void run(){
        try {
           // int  secondValue =  (int)(Math.random()*10000);
            int  secondValue =  50000;
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
