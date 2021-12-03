package org.ghy.multiThreadCore.ch03.ch02_02;

public class ThreadC extends Thread{

    private ThreadB threadB;

    public ThreadC(ThreadB threadB){
        this.threadB = threadB;
    }

    public void run(){
        threadB.interrupt();
    }
}
