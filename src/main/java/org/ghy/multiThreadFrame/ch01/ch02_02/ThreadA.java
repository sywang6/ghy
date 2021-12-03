package org.ghy.multiThreadFrame.ch01.ch02_02;

import java.util.concurrent.Exchanger;

public class ThreadA extends  Thread{
    private Exchanger<String> exchanger;

    public ThreadA(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    public void  run(){
        try {
            //exchange()具有阻塞的特点,等着另外一个线程来交换-"中国人A"
            System.out.println("在线程A中得到线程B的值="+exchanger.exchange("中国人A"));
            System.out.println("A end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
