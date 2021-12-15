package org.ghy.multiThreadFrame.ch10.ch02_05;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyService {
    public ConcurrentLinkedDeque queue = new ConcurrentLinkedDeque();

    public MyService() {
        for (int i = 0; i < 10000; i++) {
            queue.add("string"+(i+1));
        }
    }
}
