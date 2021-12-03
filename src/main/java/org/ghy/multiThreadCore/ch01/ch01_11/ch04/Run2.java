package org.ghy.multiThreadCore.ch01.ch01_11.ch04;

public class Run2 {

    public static void main(String[] args){

        MyThread myThread = new MyThread();

        myThread.start();
      /*  try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //先中断线程,在执行sleep
        myThread.interrupt();


    }

}
