package org.ghy.multiThreadFrame.ch10.ch02_01.eg4;

public class Test4 {
    public static void main(String[] args) {
        try {
            MyService4 myService4 = new MyService4();
            Thread4A thread4A = new Thread4A(myService4);
            thread4A.start();
            Thread.sleep(1000);
            Thread4B thread4B = new Thread4B(myService4);
            thread4B.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
