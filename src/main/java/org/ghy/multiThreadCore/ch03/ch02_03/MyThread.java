package org.ghy.multiThreadCore.ch03.ch02_03;

public class MyThread extends  Thread{

    public void run(){
        try{
            System.out.println("run begin Timer="+System.currentTimeMillis());
            Thread.sleep(9000);
            System.out.println("run end Timer="+System.currentTimeMillis());
        }catch ( InterruptedException e){
            e.printStackTrace();
        }
    }

}
