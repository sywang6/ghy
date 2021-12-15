package org.ghy.multiThreadFrame.ch10.ch03_02;

import java.util.concurrent.PriorityBlockingQueue;

public class Test2 {
    public static void main(String[] args) {
        try {
            PriorityBlockingQueue<Userinfo> queue = new PriorityBlockingQueue<>();
            System.out.println("begin");
            System.out.println(queue.take());
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
