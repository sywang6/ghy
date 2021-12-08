package org.ghy.multiThreadFrame.ch09.ch09_08;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private long sleepValue;

    public MyCallable(long sleepValue) {
        this.sleepValue = sleepValue;
    }

    @Override
    public String call() throws Exception {
        try {
            System.out.println(Thread.currentThread().getName()+" sleep"+sleepValue+" begin"+
                    System.currentTimeMillis());
            Thread.sleep(sleepValue);
            System.out.println(Thread.currentThread().getName()+" sleep"+sleepValue+" end"+
                    System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sleepValue+"我是返回值";
    }
}
