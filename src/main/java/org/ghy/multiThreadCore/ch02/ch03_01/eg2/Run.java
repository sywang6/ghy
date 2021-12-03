package org.ghy.multiThreadCore.ch02.ch03_01.eg2;

public class Run {
    public static void main(String[] args) {
        PrintString printString = new PrintString();
        Thread thread =  new Thread(printString);
        thread.setName("A");
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("停止A线程");
        printString.setContinuePrint(false);


    }
}
