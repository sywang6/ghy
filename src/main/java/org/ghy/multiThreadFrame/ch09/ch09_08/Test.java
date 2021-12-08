package org.ghy.multiThreadFrame.ch09.ch09_08;


import com.sun.org.apache.bcel.internal.generic.FieldOrMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) {

        try {
            List<Callable<String>> list = new ArrayList<>();
            list.add(new MyCallable(2000));
            list.add(new MyCallable(3000));
            list.add(new MyCallable(1000));
            list.add(new MyCallable(5000));
            list.add(new MyCallable(4000));
            ForkJoinPool pool = new ForkJoinPool();
            System.out.println("main begin"+System.currentTimeMillis());
            //invokeAll具有阻塞的特性,全部任务执行完了,才向下继续执行
            List<Future<String>> futureList =  pool.invokeAll(list);
            System.out.println("main end"+System.currentTimeMillis());
            for (int i = 0; i < futureList.size(); i++) {
                System.out.println(futureList.get(i).get()+" "+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
