package org.ghy.multiThreadFrame.ch06.ch02_01;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        try {
            MyCallable callable1 = new MyCallable("username1",5000);
            MyCallable callable2 = new MyCallable("username2",4000);
            MyCallable callable3 = new MyCallable("username3",3000);
            MyCallable callable4 = new MyCallable("username4",2000);
            MyCallable callable5 = new MyCallable("username5",1000);
            List<Callable> callableList = new ArrayList<>();
            callableList.add(callable1);
            callableList.add(callable2);
            callableList.add(callable3);
            callableList.add(callable4);
            callableList.add(callable5);
            List<Future> futureList = new ArrayList<>();

            ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,5,
                    TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>());
            CompletionService<String> completionService = new ExecutorCompletionService(executor);

            for (int i = 0; i < 5; i++) {
                completionService.submit(callableList.get(i));
            }
            System.out.println("run first time = "+System.currentTimeMillis());
            //CompletionService在executor的基础上又包装了一层,能够实现先执行完成的任务,先返回
            for (int i = 0; i < 5; i++) {
                System.out.println("等待打印第"+(i+1)+"个返回值");
                System.out.println(completionService.take().get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
