package org.ghy.multiThreadFrame.ch02.ch01_01;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        MyThread thread = new MyThread(service);
        thread.start();
        Thread.sleep(2000);
        service.downMethod();
    }
}
