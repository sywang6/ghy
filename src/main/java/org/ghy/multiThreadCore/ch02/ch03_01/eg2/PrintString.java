package org.ghy.multiThreadCore.ch02.ch03_01.eg2;

public class PrintString implements  Runnable{

    private boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }

    public void printStringMethod(){

        try {
            while (isContinuePrint){
                System.out.println("run printStringMathod threadName="+Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void run() {
        printStringMethod();
    }
}
