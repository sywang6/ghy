package org.ghy.multiThreadFrame.ch01.ch01_11;

/**
 * tryAcquire-尝试获取许可证,获取到了返回true,没获取到返回false,非阻塞
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThread a = new MyThread(service);
        a.setName("A");
        MyThread b = new MyThread(service);
        b.setName("B");
        a.start();
        b.start();
        Thread.sleep(10000);
    }
}
