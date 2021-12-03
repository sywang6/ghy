package org.ghy.multiThreadFrame.ch01.ch01_05;

/**
 * availablePermits()获取可用的许可证数,drainPermits()-获取可用的许可证树,并清空所有的许可证
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        MyThread a = new MyThread(service);
        a.setName("A");
        MyThread b = new MyThread(service);
        b.setName("B");

        a.start();
        Thread.sleep(500);
        b.start();

    }
}
