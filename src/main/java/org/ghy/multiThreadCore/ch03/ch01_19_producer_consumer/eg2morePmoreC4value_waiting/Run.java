package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg2morePmoreC4value_waiting;

/**
 * 多生产者,多消费者,操作值.
 * 由于使用的是notify(),如果连续出现生产者线程通知生产者线程,消费者线程通知消费者线程,就可能会出现死锁.
 * 解决方法是使用notifyAll()方法
 */
public class Run {

    public static void main(String[] args) {

        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);

        ThreadP[] pThreadArr = new ThreadP[2];
        ThreadC[] cThreadArr = new ThreadC[2];

        for(int i=0;i<2;i++){
            pThreadArr[i] = new ThreadP(p);
            pThreadArr[i].setName("生产者"+(i+1));

            cThreadArr[i] = new ThreadC(c);
            cThreadArr[i].setName("消费者"+(i+1));

            pThreadArr[i].start();
            cThreadArr[i].start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
     Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName()+" "+threadArray[i].getState() );
        }
    }

}
