package org.ghy.multiThreadFrame.ch07.ch09_01;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Run {
    public static void main(String[] args) {

        try {
            CallableA callableA = new CallableA();
            CallableB callableB = new CallableB();

            List<Callable<String>> list = new ArrayList<>();
            list.add(callableA);
            list.add(callableB);



            ExecutorService service = Executors.newCachedThreadPool();
            System.out.println("invokeAll begin "+System.currentTimeMillis());
            List<Future<String>> futureList = service.invokeAll(list);
            System.out.println("invokeAll end "+System.currentTimeMillis());
            //执行快的任务异常,慢的正常
            for (int i = 0; i <futureList.size(); i++) {
                //futureList.get(i)的顺序与添加任务的顺序相同
                System.out.println("返回的结果="+futureList.get(i).get()+" "+
                        System.currentTimeMillis());
            }
            System.out.println("mainEND");
        } catch (InterruptedException e) {
            System.out.println("报错了InterruptedException");
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("报错了ExecutionException");

        }


    }
}
