package org.ghy.multiThreadFrame.ch01.ch01_15;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        RepastService service = new RepastService();
        ThreadP[] threadPS = new ThreadP[60];
        ThreadC[] threadCS = new ThreadC[60];
        for (int i = 0; i < 60; i++) {
            threadPS[i] = new ThreadP(service);
            threadPS[i].setName("p-"+i);
            threadCS[i] = new ThreadC(service);
            threadCS[i].setName("c-"+i);
        }
        Thread.sleep(2000);
        for (int i = 0; i < 60; i++) {
            threadPS[i].start();
            threadCS[i].start();
        }
    }
}
