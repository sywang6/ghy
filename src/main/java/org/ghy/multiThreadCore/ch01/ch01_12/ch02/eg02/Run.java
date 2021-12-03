package org.ghy.multiThreadCore.ch01.ch01_12.ch02.eg02;

public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(1000);
            myThread.suspend();
            //不会打印main end,myThread线程暂停,未释放PrintStream锁,println需要这把锁
            System.out.println("main end");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
