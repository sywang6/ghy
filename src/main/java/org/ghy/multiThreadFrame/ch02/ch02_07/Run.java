package org.ghy.multiThreadFrame.ch02.ch02_07;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        ThreadA threadA1 = new ThreadA(myService);
        threadA1.setName("A");
        ThreadA threadA2 = new ThreadA(myService);
        threadA2.setName("B");
        ThreadA threadA3 = new ThreadA(myService);
        threadA3.setName("C");
        threadA1.start();
        threadA2.start();
       // threadA3.start();
        Thread.sleep(1000);
        System.out.println(myService.cyclicBarrier.isBroken());
        //reset()具有恢复Barrier的作用
       myService.cyclicBarrier.reset();
        System.out.println(myService.cyclicBarrier.isBroken());

        System.out.println(String.format("屏蔽对象的个数:%s,在屏障处等待的线程数:%s",myService.cyclicBarrier.getParties(),myService.cyclicBarrier.getNumberWaiting()));



        Thread.sleep(3000);
        threadA3.start();
        System.out.println(String.format("屏蔽对象的个数:%s,在屏障处等待的线程数:%s",myService.cyclicBarrier.getParties(),myService.cyclicBarrier.getNumberWaiting()));


    }
}
