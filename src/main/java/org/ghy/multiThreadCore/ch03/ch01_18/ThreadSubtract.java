package org.ghy.multiThreadCore.ch03.ch01_18;

public class ThreadSubtract extends  Thread{

    private Subtract r;

    public ThreadSubtract(Subtract r){
        this.r = r;
    }

    public void run(){
        r.subtract();
    }

}
