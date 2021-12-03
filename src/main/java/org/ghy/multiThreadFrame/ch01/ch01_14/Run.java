package org.ghy.multiThreadFrame.ch01.ch01_14;

public class Run {
    public static void main(String[] args) {
        ListPool pool = new ListPool();
        MyThread[] threads = new MyThread[12];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(pool);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }
}
