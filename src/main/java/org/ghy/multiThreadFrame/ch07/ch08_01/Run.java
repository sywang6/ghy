package org.ghy.multiThreadFrame.ch07.ch08_01;


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
            //执行比较快的正确,执行比较慢的任务异常了
            for (int i = 0; i <futureList.size(); i++) {
                System.out.println("返回的结果="+futureList.get(i).get()+" "+
                        System.currentTimeMillis());
            }
            System.out.println("mainEND");
        } catch (InterruptedException e) {
            System.out.println("报错了InterruptedException");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("报错了ExecutionException");
            e.printStackTrace();
        }


    }
}
