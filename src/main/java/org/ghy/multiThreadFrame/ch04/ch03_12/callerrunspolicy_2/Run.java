package org.ghy.multiThreadFrame.ch04.ch03_12.callerrunspolicy_2;

public class Run {
    public static void main(String[] args) {
        MyThreadA myThreadA = new MyThreadA();
        myThreadA.setName("AA");
        //main线程启动A线程,A线程执行B任务,这样就不会阻塞主线程
        myThreadA.start();
        System.out.println("main end!");
    }
}
