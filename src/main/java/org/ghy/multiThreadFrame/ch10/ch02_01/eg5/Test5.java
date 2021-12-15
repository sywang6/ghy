package org.ghy.multiThreadFrame.ch10.ch02_01.eg5;

public class Test5 {
    public static void main(String[] args) {

        try {
            MyService5 myService5 = new MyService5();
            Thread5A thread5A = new Thread5A(myService5);
            thread5A.start();
            Thread.sleep(1000);
            Thread5B thread5B = new Thread5B(myService5);
            thread5B.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
