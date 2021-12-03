package org.ghy.multiThreadCore.ch03.ch03_03;

public class MyThreadB extends  Thread{
    public void run(){
        try{
            for (int i = 0; i < 10; i++) {
                Tools.t1.set("B"+(i+1));
                System.out.println("B get"+Tools.t1.get());
                int sleepvalue = (int)(Math.random()*1000);
                Thread.sleep(sleepvalue);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
