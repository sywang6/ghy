package org.ghy.multiThreadFrame.ch01.ch01_12;

public class Run {

    public static void main(String[] args) {

        Service service = new Service();
        MyThread[]  myThreads = new MyThread[12];
        for (int i = 0; i < myThreads.length; i++) {
            myThreads[i] = new MyThread(service);
            myThreads[i].start();

        }

    }
}
