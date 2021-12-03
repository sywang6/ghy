package org.ghy.multiThreadFrame.ch02.ch02_05;

/**
 * await(5, TimeUnit.SECONDS),超时会抛出TimeoutException异常,并破坏Barrier
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MythreadA mythreadA1 = new MythreadA(service);
        MythreadA mythreadA2 = new MythreadA(service);
        mythreadA1.start();
        mythreadA2.start();
        Thread.sleep(10000);
        MythreadA mythreadA3 = new MythreadA(service);
        mythreadA3.start();
    }
}
