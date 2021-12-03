package org.ghy.multiThreadFrame.ch01.ch01_13;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private Semaphore semaphore = new Semaphore(3);
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void sayHello(){
        try{
            String threadName = Thread.currentThread().getName();
            semaphore.acquire();
            System.out.println(threadName+"准备");
            reentrantLock.lock();
            System.out.println(threadName+"begin hello "+System.currentTimeMillis());
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName+"say "+(i+1));
            }
            System.out.println(threadName+"end hello "+System.currentTimeMillis());
            reentrantLock.unlock();
            semaphore.release();
            System.out.println(threadName+"结束");
        }catch (InterruptedException e){

        }
    }
}
