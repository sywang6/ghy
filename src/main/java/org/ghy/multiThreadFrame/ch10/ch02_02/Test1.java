package org.ghy.multiThreadFrame.ch10.ch02_02;

public class Test1 {

    public static void main(String[] args) {
        MyService1 service1 = new MyService1();
        ThreadA a  = new ThreadA(service1);
        ThreadA b = new ThreadA(service1);
        a.start();
        b.start();

    }
}
