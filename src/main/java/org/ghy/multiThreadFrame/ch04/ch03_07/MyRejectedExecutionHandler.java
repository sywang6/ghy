package org.ghy.multiThreadFrame.ch04.ch03_07;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(((MyRunnable1)r).getUsername()+" 被拒绝执行");
    }
}
