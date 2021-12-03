package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg1onePoneC4value;

/**
 * 一生产者一消费者,操作值
 */
public class Run {

    public static void main(String[] args) {

        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);

        ThreadP pThread = new ThreadP(p);
        ThreadC cThread = new ThreadC(c);

        pThread.start();
        cThread.start();


    }

}
