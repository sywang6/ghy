package org.ghy.multiThreadFrame.ch04.ch03_06;

import com.sun.org.apache.bcel.internal.generic.DADD;

import java.util.Date;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactoryA implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName("高洪岩: "+new Date());
        return thread;
    }
}
