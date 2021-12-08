package org.ghy.multiThreadFrame.ch06.ch07_01;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Run1 {
    public static void main(String[] args) {
        try {
            UserInfo userInfo = new UserInfo();
            MyRunnable myRunnable = new MyRunnable(userInfo);

            Executor executor = Executors.newCachedThreadPool();
            CompletionService completionService = new ExecutorCompletionService(executor);
            Future<UserInfo> future =  completionService.submit(myRunnable,userInfo);
            System.out.println(future.get().getUsername()+" "+future.get().getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
