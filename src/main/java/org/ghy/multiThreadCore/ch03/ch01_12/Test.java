package org.ghy.multiThreadCore.ch03.ch01_12;

public class Test {
    public static void main(String[] args) {
        try{
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();
            Thread.sleep(5000);
            a.interrupt();

        }catch (Exception e){
            System.out.println("---------");
            e.printStackTrace();
        }
    }
}
