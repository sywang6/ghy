package org.ghy.multiThreadFrame.ch01.ch01_04.eg1;

/**
 * Semaphore_acquireUninterruptibly_1
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        Thread.sleep(500);
        ThreadA b = new ThreadA(service);
        b.setName("B");
        b.start();
        Thread.sleep(1000);
        b.interrupt();
        System.out.println("main线程中断b");
    }
}
