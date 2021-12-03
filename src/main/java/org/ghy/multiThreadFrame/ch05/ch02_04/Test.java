package org.ghy.multiThreadFrame.ch05.ch02_04;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
    FutureTask futureTask;

    public static void main(String[] args) {
        try {
            Userinfo userinfo = new Userinfo();
            MyRunnable myRunnable = new MyRunnable(userinfo);
            ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,10,10,
                    TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
            Future<Userinfo> future =  poolExecutor.submit(myRunnable,userinfo);
            System.out.println("begin time="+System.currentTimeMillis());
             future.get();
            System.out.println("get value "+userinfo.getUsername()+" "+userinfo.getPassword());
            System.out.println("end time="+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
