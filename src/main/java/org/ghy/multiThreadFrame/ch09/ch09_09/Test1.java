package org.ghy.multiThreadFrame.ch09.ch09_09;

import java.util.concurrent.ForkJoinPool;

public class Test1 {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("main end!");
    }
}
