package org.ghy.multiThreadCore.ch01.ch01_03;

public class Run2 {

    public static void main(String[] args){

        MyThread myThread = new MyThread();
        myThread.run();
        myThread.start();
        //输出:
        //构造方法打印:main
        //run方法打印:main
        //run方法打印:Thread-0

        //构造方法肯定是由main线程执行的, 如果直接调用run方法,run方法也是由main线程执行的,如果调用线程的start方法
        //启动一个新的线程,run方法就是由新的线程调用的输出Thread-0
    }
}
