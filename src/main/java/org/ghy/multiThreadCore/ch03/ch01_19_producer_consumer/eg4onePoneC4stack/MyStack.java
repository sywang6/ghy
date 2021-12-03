package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg4onePoneC4stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 一生产者一消费者,操作值
 */
public class MyStack {

    private List<String> list = new ArrayList();

    synchronized public void push() {
        try {
            if (list.size() == 1) {
                this.wait();
            }
            list.add("anyString=" + Math.random());
            this.notify();
            System.out.println("push=" + list.size());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public String pop(){
        String returnValue = "";
        try{
            if(list.size() == 0){
                System.out.println("pop操作中的:"+Thread.currentThread().getName()+" 线程程wait状态");
                this.wait();
            }
            returnValue=list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("pop="+list.size());
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return returnValue;
    }

}
