package org.ghy.multiThreadFrame.ch04.ch03_06;

import java.util.Date;
import java.util.concurrent.ThreadFactory;

public class MyThreadFactoryB implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread newThread = new Thread(r);
        newThread.setName("我的新名称: "+new Date());
        newThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("自定义异常启用: "+t.getName()+" "+e.getMessage());
                e.printStackTrace();
            }
        });
        return  newThread;
    }
}
