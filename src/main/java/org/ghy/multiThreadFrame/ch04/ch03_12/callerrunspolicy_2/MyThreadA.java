package org.ghy.multiThreadFrame.ch04.ch03_12.callerrunspolicy_2;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadA extends  Thread{

    public void run(){
        //在A线程里面执行B任务
        MyThreadB   myThreadB = new MyThreadB();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(2);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,3,5, TimeUnit.SECONDS
        ,linkedBlockingDeque,new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println(" a being "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
        poolExecutor.execute(myThreadB);
        poolExecutor.execute(myThreadB);
        poolExecutor.execute(myThreadB);
        poolExecutor.execute(myThreadB);
        poolExecutor.execute(myThreadB);
        poolExecutor.execute(myThreadB);
        System.out.println(" a end "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
        System.out.println(" a end "+System.currentTimeMillis());
    }
}
