package org.ghy.multiThreadFrame.ch04.ch02_03;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("定制池中的线程对象的名称:"+Math.random());
        return thread;
    }
}
