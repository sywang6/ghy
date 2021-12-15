package org.ghy.multiThreadFrame.ch10.ch03_07.eg3;



public class ThreadB2 extends Thread{

    private MyserviceB myserviceB;

    public ThreadB2(MyserviceB myserviceB) {
        this.myserviceB = myserviceB;
    }
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName()+"beginB "+System.currentTimeMillis());
           myserviceB.queue.transfer("我是从ThreadB2来");
            //myserviceB.queue.transfer("我是从ThreadB2来2");
            System.out.println(Thread.currentThread().getName()+" endB"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
