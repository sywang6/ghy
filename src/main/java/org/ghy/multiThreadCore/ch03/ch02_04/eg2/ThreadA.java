package org.ghy.multiThreadCore.ch03.ch02_04.eg2;

public class ThreadA extends  Thread{

    private ThreadB threadB;

    public ThreadA(ThreadB threadB) {
        this.threadB = threadB;
    }

    public void run(){
        try{
            synchronized (threadB){
                threadB.start();
                threadB.join();
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    String newString = new String();
                    Math.random();
                }
            }
        }catch ( InterruptedException e){
            e.printStackTrace();
        }
    }



}
