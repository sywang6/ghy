package org.ghy.multiThreadFrame.ch10.ch03_01;

import java.util.concurrent.ArrayBlockingQueue;

public class Put {
    public static void main(String[] args) {
        try {
            ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
            queue.put("a1");
            queue.put("a1");
            queue.put("a1");
            System.out.println(queue.size());
            System.out.println(System.currentTimeMillis());
            queue.put("a4");
            System.out.println(System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
