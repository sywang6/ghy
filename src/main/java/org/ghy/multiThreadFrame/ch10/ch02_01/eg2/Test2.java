package org.ghy.multiThreadFrame.ch10.ch02_01.eg2;

public class Test2 {
    public static void main(String[] args) {
        MyService2 myService1 = new MyService2();
        Thread2A thread1A = new Thread2A(myService1);
        Thread2B thread1B = new Thread2B(myService1);
        thread1A.start();
        thread1B.start();
    }
}
