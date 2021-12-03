package org.ghy.multiThreadFrame.ch02.ch02_01.eg1;

import java.util.concurrent.CyclicBarrier;

public class Run {
    public static void main(String[] args) {
        //最后到达的线程执行Runnable,执行完成后所有线程才继续向后执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,
                new Runnable() {
            @Override
            public void run() {
                System.out.println("全都到了!");
                System.out.println(Thread.currentThread().getName()+"休息一下下"+System.currentTimeMillis());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        MyThread[] threads = new MyThread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(cyclicBarrier);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
