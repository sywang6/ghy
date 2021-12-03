package org.ghy.multiThreadFrame.ch02.ch02_01.eg2;

import java.util.concurrent.CyclicBarrier;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        //最后到达的线程执行Runnable,执行完成后所有线程才继续向后执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,
                new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"来了2个,发车!");
             /*   System.out.println(Thread.currentThread().getName()+"休息一下下"+System.currentTimeMillis());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        });
        MyThread[] threads = new MyThread[6];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(cyclicBarrier);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
            Thread.sleep(2000);
        }
    }
}
