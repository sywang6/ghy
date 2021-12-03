package org.ghy.multiThreadCore.ch03.ch02_04.eg2;

public class ThreadB extends  Thread{

    public void run(){
        try{
            System.out.println("b run begin Timer="+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("b run end Timer="+System.currentTimeMillis());
        }catch ( InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public  void bService(){
        System.out.println("打印了bService timer="+System.currentTimeMillis());
    }

}
