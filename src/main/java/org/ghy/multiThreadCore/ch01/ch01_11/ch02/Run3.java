package org.ghy.multiThreadCore.ch01.ch01_11.ch02;



public class Run3 {

    public static void main(String[] args){
        try{
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            //中断thread代表的线程
            thread.interrupt();
            //isInterrupted()实例方法,判断thread所代表的线程有没有被中断,并且不会清除中断标记
            System.out.println("是否停止1?="+thread.isInterrupted());
            System.out.println("是否停止2?="+thread.isInterrupted());
            //是否停止1?=true
            //是否停止2?=true
        }catch(Exception e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }

}
