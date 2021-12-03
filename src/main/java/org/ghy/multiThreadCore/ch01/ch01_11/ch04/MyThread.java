package org.ghy.multiThreadCore.ch01.ch01_11.ch04;

public class MyThread extends  Thread{

    public void run(){

        try {
            for(int i =0;i<200000;i++){
                System.out.println(i++);
            }

            System.out.println(Thread.currentThread().getName()+" start");
            System.out.println(Thread.currentThread().getName()+" isInterrupted-0:"+Thread.currentThread().isInterrupted());
            Thread.sleep(200000);
            System.out.println(Thread.currentThread().getName()+" end");
        } catch (InterruptedException e) {
           System.out.println(Thread.currentThread().getName()+" isInterrupted-1:"+Thread.currentThread().isInterrupted());
            e.printStackTrace();
        }

    }

}
