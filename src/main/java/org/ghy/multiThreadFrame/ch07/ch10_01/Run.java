package org.ghy.multiThreadFrame.ch07.ch10_01;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Run {
    public static void main(String[] args) {

        try {
            CallableA callableA = new CallableA();
            CallableB callableB = new CallableB();

            List<Callable<String>> list = new ArrayList<>();
            list.add(callableA);
            list.add(callableB);

            ExecutorService service = Executors.newCachedThreadPool();
            System.out.println("X "+System.currentTimeMillis());
            List<Future<String>> futureList = service.invokeAll(list,2, TimeUnit.SECONDS);
            System.out.println("Y "+System.currentTimeMillis());
            for (int i = 0; i <futureList.size(); i++) {
                System.out.println("for 第"+(i+1)+"次循环");
                //先慢后快,超时抛出了CancellationException,不在取后面执行得比较快的任务结果
                System.out.println("返回的结果="+futureList.get(i).get()+" "+
                        System.currentTimeMillis());
            }
            System.out.println("Z "+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("报错了InterruptedException");
        } catch (ExecutionException e) {
          e.printStackTrace();
            System.out.println("报错了ExecutionException");

        }
   /*     catch (Exception e) {
            e.printStackTrace();
            System.out.println("报错了Exception");

        }*/

        System.out.println("mmmm");

    }
}
