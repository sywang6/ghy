package org.ghy.multiThreadFrame.ch05.ch02_06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Run1 {
    public static void main(String[] args) {
        try {
            MyCallable callable = new MyCallable();
            ThreadPoolExecutor executor = new ThreadPoolExecutor(2,3,5, TimeUnit.SECONDS
                    ,new LinkedBlockingDeque<Runnable>());
            System.out.println("begin "+System.currentTimeMillis());
            Future<String> future =  executor.submit(callable);
            System.out.println("返回值 "+future.get(5,TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
