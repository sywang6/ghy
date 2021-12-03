package org.ghy.multiThreadCore.ch01.ch01_12.ch01;

/**
 * 线程的暂停与恢复
 */
public class Run {
    public static void main(String[] args) {
        try{
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(5000);
            myThread.suspend();
            System.out.println("A="+System.currentTimeMillis()+" i="+myThread.getI());
            Thread.sleep(5000);
            System.out.println("A="+System.currentTimeMillis()+" i="+myThread.getI());
            myThread.resume();
            Thread.sleep(5000);
            myThread.suspend();
            System.out.println("B="+System.currentTimeMillis()+" i="+myThread.getI());
            Thread.sleep(5000);
            System.out.println("B="+System.currentTimeMillis()+" i="+myThread.getI());

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
