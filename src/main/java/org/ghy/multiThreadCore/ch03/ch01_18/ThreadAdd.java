package org.ghy.multiThreadCore.ch03.ch01_18;

public class ThreadAdd extends  Thread{

    private Add p;

    public ThreadAdd(Add p){
        this.p = p;
    }

    public void run(){
        p.add();
    }

}
