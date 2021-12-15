package org.ghy.multiThreadFrame.ch10.ch02_05;

public class Test {
    public static void main(String[] args) {
        try {
            MyService service = new MyService();
            ThreadA a = new ThreadA(service);
            ThreadB b = new ThreadB(service);
            a.start();
            b.start();
            a.join();
            b.join();
            System.out.println(service.queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
