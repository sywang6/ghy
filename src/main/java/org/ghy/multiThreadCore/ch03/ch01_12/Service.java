package org.ghy.multiThreadCore.ch03.ch01_12;

public class Service {

    public void testMethod(Object lock){
        try{
            /*Thread.currentThread().interrupt();
            System.out.println("设置了中断标记");*/

            synchronized (lock){
                System.out.println("begin wait()");
                lock.wait();
                System.out.println(" end wait()");
            }


        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName()+"出现了异常,因为呈wait状态的线程被中断了");
        }
    }
}
