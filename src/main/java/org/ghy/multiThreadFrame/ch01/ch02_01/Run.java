package org.ghy.multiThreadFrame.ch01.ch02_01;

import java.util.concurrent.Exchanger;

public class Run {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA a = new ThreadA(exchanger);
        a.start();
        System.out.println("main end!");
    }
}
