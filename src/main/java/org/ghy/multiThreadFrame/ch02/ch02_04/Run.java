package org.ghy.multiThreadFrame.ch02.ch02_04;

import java.util.concurrent.CyclicBarrier;

/**
 * 执行wait方法会检查中断,如果检查到中断,barrier就会被破坏,抛出BrokenBarrierException异常,
 * 被破坏的barrier在使用,还是会抛出BrokenBarrierException异常
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        int parties = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties, new Runnable() {
            @Override
            public void run() {
                System.out.println("都到了!");
            }
        });

        MyService myService = new MyService(cyclicBarrier);
        MyThread[] threads = new MyThread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(myService);
            threads[i].start();
        }

        Thread.sleep(10000);

        for (int i = 0; i < threads.length; i++) {
            new MyThread(myService).start();
        }

    }
}
