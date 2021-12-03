package org.ghy.multiThreadFrame.ch01.ch01_04.eg2;

import java.util.concurrent.Semaphore;

public class Service {

    private Semaphore semaphore = new Semaphore(1);

    public void testMethod(){
        try{
            semaphore.acquireUninterruptibly();
            System.out.println(Thread.currentThread().getName()+" begin timer "+System.currentTimeMillis());
            if("A".equals(Thread.currentThread().getName())){
                Thread.sleep(1000);
            }
            for (int i = 0; i < Integer.MAX_VALUE/50; i++) {
                String newString = new String();
                Math.random();
            }
            System.out.println(Thread.currentThread().getName()+" end timer "+System.currentTimeMillis());
            semaphore.release();
        }catch (InterruptedException e){
            System.out.println("线程"+Thread.currentThread().getName()+"进入了try-catch");
            e.printStackTrace();
        }
    }
}
