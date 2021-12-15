package org.ghy.multiThreadFrame.ch10.ch03_06;

import java.util.concurrent.DelayQueue;

public class Test1 {
    public static void main(String[] args) {
        try {
            DelayQueue<Userinfo> queue = new DelayQueue<>();
            queue.add(new Userinfo(7000,"username5"));
            queue.add(new Userinfo(6000,"username4"));
            queue.add(new Userinfo(5000,"username3"));
            queue.add(new Userinfo(4000,"username2"));
            queue.add(new Userinfo(3000,"username1"));
            for (int i = 0; i < 5; i++) {
                System.out.println(queue.take().getUsername()+" "+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
