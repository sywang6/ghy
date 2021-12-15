package org.ghy.multiThreadFrame.ch10.ch02_04;

public class Test1 {
    public static void main(String[] args) {
        try {
            MyService1 service1 = new MyService1();
            ThreadA a = new ThreadA(service1);
            ThreadB b = new ThreadB(service1);
            a.start();
            b.start();
            a.join();
            b.join();
            System.out.println(service1.queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
