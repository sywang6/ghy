package org.ghy.multiThreadFrame.ch10.ch03_05;

public class Test2 {
    public static void main(String[] args) {
        try {
            MyService service = new MyService();
            ThreadPut threadPut = new ThreadPut(service);
            ThreadTake threadTake = new ThreadTake(service);
            threadTake.start();
            Thread.sleep(2000);
            threadPut.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
