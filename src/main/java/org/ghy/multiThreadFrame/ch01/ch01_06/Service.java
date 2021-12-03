package org.ghy.multiThreadFrame.ch01.ch01_06;

import java.util.concurrent.Semaphore;

public class Service {

    private Semaphore semaphore = new Semaphore(1);
    public void testMethod(){
        try{
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println("大约还有"+semaphore.getQueueLength()+"个线程在等待许可证");
            System.out.println("是否有线程正在等待许可证呢? "+semaphore.hasQueuedThreads());
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
