package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg1onePoneC4value;

/**
 * 消费者线程
 */
public class ThreadC extends  Thread{

    private C c;

    public ThreadC(C c){
        this.c = c;
    }

    public void run(){
        while (true){
            c.getValue();
        }
    }
}
