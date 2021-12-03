package org.ghy.multiThreadCore.ch03.ch02_04.eg1;

public class ThreadA extends  Thread{

    private ThreadB threadB;

    public ThreadA(ThreadB threadB) {
        this.threadB = threadB;
    }

    public void run(){
        try{
            synchronized (threadB){
                threadB.start();
                Thread.sleep(6000);
            }
        }catch ( InterruptedException e){
            e.printStackTrace();
        }
    }



}
