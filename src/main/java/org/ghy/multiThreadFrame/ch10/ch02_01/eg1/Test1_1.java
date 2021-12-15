package org.ghy.multiThreadFrame.ch10.ch02_01.eg1;

public class Test1_1 {
    public static void main(String[] args) {
        MyService1 myService1 = new MyService1();
        Thread1A thread1A = new Thread1A(myService1);
        thread1A.start();
    }
}
