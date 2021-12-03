package org.ghy.multiThreadCore.ch01.ch01_12.ch02;

public class SynchronizedObject {

    synchronized public void printString(){
        System.out.println("begin");
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("a线程永远suspend了");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }

}
