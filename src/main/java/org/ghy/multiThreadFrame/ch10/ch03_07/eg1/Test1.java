package org.ghy.multiThreadFrame.ch10.ch03_07.eg1;

public class Test1 {
    public static void main(String[] args) {
        MyServiceA serviceA = new MyServiceA();
        ThreadA a = new ThreadA(serviceA);
        a.start();
    }
}
