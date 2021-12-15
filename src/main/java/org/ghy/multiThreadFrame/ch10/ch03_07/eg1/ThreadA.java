package org.ghy.multiThreadFrame.ch10.ch03_07.eg1;

public class ThreadA extends  Thread{

    private  MyServiceA serviceA;

    public ThreadA(MyServiceA serviceA) {
        this.serviceA = serviceA;
    }
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName()+" begin "+System.currentTimeMillis());
            System.out.println("取得的值: "+serviceA.queue.take());
            System.out.println(Thread.currentThread().getName()+" end "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
