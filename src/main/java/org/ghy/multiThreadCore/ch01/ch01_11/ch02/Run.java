package org.ghy.multiThreadCore.ch01.ch01_11.ch02;



public class Run {

    public static void main(String[] args){
        try{
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            //中断thread代表的线程
            thread.interrupt();

            //跟踪一下Thread.interrupted()就发现,判断的是当前线程有没有被中断,当前线程也就是运行Thread.interrupted()这行代码的线程,
            //在这里也就是main线程. 显然面线程没有被中断,这里两次返回的都是false.Thread.interrupted()还有清楚当前线程中断标志的作用
            //在这个例子里没有体现出来
            System.out.println("是否停止1?="+Thread.interrupted());
            System.out.println("是否停止2?="+Thread.interrupted());
        }catch(InterruptedException e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }

}
