package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg4onePoneC4stack;

/**
 * 生产者线程
 */
public class ThreadP extends  Thread{

    private P p;

    public ThreadP(P p){
        this.p = p;
    }

    public void run(){
        while (true){
            p.pushService();
        }
    }
}
