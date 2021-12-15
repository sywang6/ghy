package org.ghy.multiThreadFrame.ch10.ch02_01.eg3;

public class Test3 {
    public static void main(String[] args) {
        MyService3 myService1 = new MyService3();
        Thread3A thread1A = new Thread3A(myService1);
        Thread3B thread1B = new Thread3B(myService1);
        thread1A.start();
        thread1B.start();
    }
}
