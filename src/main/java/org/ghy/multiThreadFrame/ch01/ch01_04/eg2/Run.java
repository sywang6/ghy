package org.ghy.multiThreadFrame.ch01.ch01_04.eg2;

/**
 * Semaphore_acquireUninterruptibly_2,acquireUninterruptibly线程在等待许可证的时候不能被中断
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
