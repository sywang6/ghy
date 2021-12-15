package org.ghy.multiThreadFrame.ch10.ch03_07.eg3;



public class ThreadB1 extends Thread{

    private MyserviceB myserviceB;

    public ThreadB1(MyserviceB myserviceB) {
        this.myserviceB = myserviceB;
    }
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName()+"beginA "+System.currentTimeMillis());
            System.out.println("取得的值: "+myserviceB.queue.take());
            System.out.println(Thread.currentThread().getName()+" endA"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
