package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg7morePmoreC4stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 一生产者一消费者,操作值
 */
public class MyStack {

    private List<String> list = new ArrayList();

    synchronized public void push() {
        try {
            //只有一个生产者,用if也可以
            while (list.size() == 1) {
                this.wait();
            }
            list.add("anyString=" + Math.random());
            //只有一个生产者,用notify也可以
            this.notifyAll();
            System.out.println("push=" + list.size());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public String pop(){
        String returnValue = "";
        try{
            //注意wile与if的使用
            while(list.size() == 0){
                System.out.println("pop操作中的:"+Thread.currentThread().getName()+" 线程程wait状态");
                this.wait();
            }
            returnValue=list.get(0);
            list.remove(0);
            //在多消费者的时候需要使用notifyAll(),不然连续出现消费者通知消费者,导致假死
            this.notifyAll();
            System.out.println("pop="+list.size());
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return returnValue;
    }

}
