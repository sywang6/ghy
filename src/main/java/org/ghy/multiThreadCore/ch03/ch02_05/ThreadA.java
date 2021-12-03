package org.ghy.multiThreadCore.ch03.ch02_05;

public class ThreadA extends  Thread{

    private ThreadB b;

    public ThreadA(ThreadB b) {
        this.b = b;
    }

    public void run(){
        try{
            synchronized (b){
                System.out.println("begin A ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
                Thread.sleep(500);
                System.out.println("end A ThreadName="+Thread.currentThread().getName()+" "+System.currentTimeMillis());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
