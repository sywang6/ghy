package org.ghy.multiThreadFrame.ch06.ch04_01;

import javax.security.sasl.SaslServer;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Run {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService completionService = new ExecutorCompletionService(executorService);
        for (int i = 0; i < 1; i++) {
            completionService.submit(new Callable() {
                @Override
                public Object call() throws Exception {
                    Thread.sleep(3000);
                    System.out.println("3秒过后");
                    return "高洪岩3s";
                }
            });
        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            //如果任务还没有执行完成,返回的Future是null
            Future<String> future = completionService.poll();
            if(future!=null ){
                String result = null;
                try {
                    result = future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                System.out.println(result);
                break;
            }else{
                System.out.println("null");
            }

            }


    }
}
