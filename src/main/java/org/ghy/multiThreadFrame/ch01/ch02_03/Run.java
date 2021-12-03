package org.ghy.multiThreadFrame.ch01.ch02_03;

import java.util.concurrent.Exchanger;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA a = new ThreadA(exchanger);
        ThreadB b = new ThreadB(exchanger);
        a.start();
        //Thread.sleep(4000);
        Thread.sleep(6000);
        b.start();
        System.out.println("main end!");
    }
}
