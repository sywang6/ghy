package org.ghy.multiThreadFrame.ch01.ch02_03;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadA extends  Thread{
    private Exchanger<String> exchanger;

    public ThreadA(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }
    public void  run(){
        try {
            //exchange()具有阻塞的特点,等着另外一个线程来交换-"中国人A"
            System.out.println("在线程A中得到线程B的值="+exchanger.exchange("中国人A",5, TimeUnit.SECONDS));
            System.out.println("A end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
