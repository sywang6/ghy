package org.ghy.multiThreadFrame.ch10.ch02_01.eg1;

public class Test1_2 {
    public static void main(String[] args) {
        MyService1 myService1 = new MyService1();
        Thread1A thread1A = new Thread1A(myService1);
        Thread1B thread1B = new Thread1B(myService1);
        //我在本地运行的时候并没有出现假死现象
        thread1A.start();
        thread1B.start();
    }
}
