package org.ghy.multiThreadFrame.ch10.ch03_07.eg2;

public class ThreadB2 extends Thread{

    private MyserviceB myserviceB;

    public ThreadB2(MyserviceB myserviceB) {
        this.myserviceB = myserviceB;
    }
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName()+"beginB "+System.currentTimeMillis());
            //没有被取走之前都是阻塞的.但是其他线程还可以向TransferQueue放元素
            myserviceB.queue.transfer("我从ThreadB2来");
            System.out.println(Thread.currentThread().getName()+" endB"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
