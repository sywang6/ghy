package org.ghy.multiThreadCore.ch03.ch02_05;

public class ThreadB extends  Thread{

    synchronized public void run(){
        try {
           System.out.println("begin B ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
            Thread.sleep(500);
            System.out.println(" end B ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

