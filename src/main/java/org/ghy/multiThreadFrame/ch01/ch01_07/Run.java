package org.ghy.multiThreadFrame.ch01.ch01_07;




/**
 * 公平信号量与非公平信号量,TODO,结合源码加深理解.
 * 获得锁的顺序与排队顺序有关,但并保证先排队的线程就一定先获得锁,仅仅是概率上的保证
 */
public class Run {
    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread[] myThreads = new MyThread[5];
        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i] = new MyThread(service);
        }
        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i].start();
        }
    }
}
