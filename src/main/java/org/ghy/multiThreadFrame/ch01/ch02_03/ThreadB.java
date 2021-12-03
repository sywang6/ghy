package org.ghy.multiThreadFrame.ch01.ch02_03;

import java.util.concurrent.Exchanger;

public class ThreadB extends  Thread{
    private Exchanger<String> exchanger;

    public ThreadB(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    public void  run(){
        try {
            System.out.println("在线程B中得到线程A的值="+exchanger.exchange("中国人B"));
            System.out.println("B end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
