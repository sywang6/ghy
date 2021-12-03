package org.ghy.multiThreadFrame.ch04.ch03_12.callerrunspolicy_1;


import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThreadA a  = new MyThreadA();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(2);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS,
                linkedBlockingDeque, new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println(" a being "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
        poolExecutor.execute(a);
        poolExecutor.execute(a);
        poolExecutor.execute(a);
        poolExecutor.execute(a);
        poolExecutor.execute(a);
        System.out.println(" a 6 "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
        poolExecutor.execute(a);
        Thread.sleep(1000);
        System.out.println(" a 7 "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
        poolExecutor.execute(a);
        poolExecutor.execute(a);
        System.out.println(" a end "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());

    }
}
