package org.ghy.multiThreadFrame.ch01.ch01_12;

import java.util.concurrent.Semaphore;

public class Service {

    private Semaphore semaphore = new Semaphore(3);

    public void sayHello(){
        try{
            String threadName = Thread.currentThread().getName();
            semaphore.acquire();
            System.out.println(threadName+"准备");
            System.out.println(threadName+"begin hello "+System.currentTimeMillis());
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName+"say "+(i+1));
            }
            System.out.println(threadName+"end hello "+System.currentTimeMillis());
            semaphore.release();
            System.out.println(threadName+"结束");
        }catch (InterruptedException e){

        }
    }
}
