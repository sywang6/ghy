package org.ghy.multiThreadCore.ch03.ch02_04.eg2;

public class ThreadC extends  Thread{

    private ThreadB threadB;

    public ThreadC(ThreadB threadB) {
        this.threadB = threadB;
    }

    public  void run(){
        threadB.bService();
    }
}
