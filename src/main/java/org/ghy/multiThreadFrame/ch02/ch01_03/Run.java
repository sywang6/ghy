package org.ghy.multiThreadFrame.ch02.ch01_03;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyService myService = new MyService();
        MyThread[]  myThreads = new MyThread[10];
        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i] = new MyThread(myService);
            myThreads[i].setName("runner"+(i+1));
            myThreads[i].start();
        }
        Thread.sleep(2000);
        myService.downMethod();
    }
}
