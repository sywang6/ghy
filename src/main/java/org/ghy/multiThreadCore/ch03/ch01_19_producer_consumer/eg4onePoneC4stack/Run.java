package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg4onePoneC4stack;

/**
 * 一生产一消费,操作栈
 */
public class Run {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        P p = new P(myStack);
        C c = new C(myStack);

        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(c);
        threadP.start();
        threadC.start();

    }

}
