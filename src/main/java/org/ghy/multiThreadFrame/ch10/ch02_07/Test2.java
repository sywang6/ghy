package org.ghy.multiThreadFrame.ch10.ch02_07;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyServiceB serviceB = new MyServiceB();
        ThreadB[] threadBS = new ThreadB[100];
        for (int i = 0; i < threadBS.length; i++) {
            threadBS[i] = new ThreadB(serviceB);
        }
        for (int i = 0; i < threadBS.length; i++) {
            threadBS[i].start();
        }
        Thread.sleep(3000);
        System.out.println(MyServiceB.set.size());
    }
}
