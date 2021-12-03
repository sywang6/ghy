package org.ghy.multiThreadFrame.ch01.ch01_01;

public class Run {

    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("a");
        ThreadA b = new ThreadA(service);
        b.setName("b");
        ThreadA c = new ThreadA(service);
        c.setName("c");
        a.start();
        b.start();
        c.start();
    }
}
