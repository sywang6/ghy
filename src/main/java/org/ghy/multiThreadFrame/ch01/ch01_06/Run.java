package org.ghy.multiThreadFrame.ch01.ch01_06;

/**
 * getQueueLength()-有多少个线程在等待信号量 和  hasQueuedThreads-有没有线程在等待信号量
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();

        MyThread a = new MyThread(service);
        a.start();
        for (int i = 0; i < 4; i++) {
            new MyThread(service).start();
        }
    }
}
