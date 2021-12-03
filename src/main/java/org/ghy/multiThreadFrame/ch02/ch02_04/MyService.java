package org.ghy.multiThreadFrame.ch02.ch02_04;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyService {

    private CyclicBarrier cyclicBarrier;

    public MyService(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    private void  beginRun(int count){
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+" 到了 在等待其他人都到了开始起跑");
            if ("Thread-2".equals(threadName)){
                System.out.println("Thread-2进来了");
                Thread.sleep(5000);
                //Integer.parseInt("a");
                Thread.currentThread().interrupt();
            }
            cyclicBarrier.await();
            System.out.println("都到了,开始跑!");
            System.out.println(threadName+" 到达终点,并结束第"+count+"赛段");
        } catch (InterruptedException  e) {
            System.out.println("进入了InterruptedException"+cyclicBarrier.isBroken());
            e.printStackTrace();
        }catch (BrokenBarrierException e){
            System.out.println("进入了BrokenBarrierException"+cyclicBarrier.isBroken());
            e.printStackTrace();
        }
    }

    public void testA(){
        for (int i = 0; i < 1; i++) {
            beginRun(1);
        }
    }

}
