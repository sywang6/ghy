package org.ghy.multiThreadFrame.ch02.ch02_05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MyService {

    public CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
        @Override
        public void run() {
            System.out.println("彻底结束了"+System.currentTimeMillis());
        }
    });

    public void testMethod(){
    String threadName = Thread.currentThread().getName();
        try {
            System.out.println(threadName+"准备! "+System.currentTimeMillis());
            if("Thread-0".equals(threadName)){
                System.out.println("Thread-0执行了cyclicBarrier.await(5, TimeUnit.SECONDS)");
                //超时会抛出TimeoutException异常,并破坏Barrier
                cyclicBarrier.await(5, TimeUnit.SECONDS);
            }
            else if("Thread-1".equals(threadName)){
                System.out.println("Thread-1执行了cyclicBarrier.await()");
                cyclicBarrier.await();
            }else{
                System.out.println(threadName+"执行了cyclicBarrier.await()");
                cyclicBarrier.await();
            }
            System.out.println(threadName+"开始! "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            System.out.println(threadName+"进入InterruptedException! "+System.currentTimeMillis());
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            System.out.println(threadName+"进入BrokenBarrierException! "+System.currentTimeMillis());
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println(threadName+"进入TimeoutException! "+System.currentTimeMillis());
            e.printStackTrace();
        }
    }

}
