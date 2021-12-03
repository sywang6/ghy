package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg5onePmoreC4stack;

/**
 * 一生产者多消费者,操作栈,wait条件发生改变,可能会出现IndexOutOfBoundsException异常
 */
public class Run {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();

        P p = new P(myStack);
        C c = new C(myStack);

        ThreadP threadP = new ThreadP(p);

        ThreadC threadC = new ThreadC(c);
        ThreadC threadC1 = new ThreadC(c);
        ThreadC threadC2 = new ThreadC(c);

        threadP.start();
        threadC.start();
        threadC1.start();
        threadC2.start();

    }

}
