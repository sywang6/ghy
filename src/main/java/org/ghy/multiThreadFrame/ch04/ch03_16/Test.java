package org.ghy.multiThreadFrame.ch04.ch03_16;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,10,
                TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
        for(int i=0;i<50;i++){
            MyRunnable myRunnable = new MyRunnable("username"+(i+1));
            executor.execute(myRunnable);
        }
    }
}
