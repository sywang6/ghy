package org.ghy.multiThreadFrame.ch07.ch06_01.eg1;

import org.ghy.multiThreadFrame.ch07.ch06_01.eg1.MyCallableA;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Run {
    public static void main(String[] args) {

        try {
            List<Callable<String>> list = new ArrayList<>();
            list.add(new MyCallableA());
            ExecutorService executorService = Executors.newCachedThreadPool();
            String getValue = executorService.invokeAny(list,1, TimeUnit.SECONDS);
            System.out.println("返回值 "+getValue);
            System.out.println("zzzzzzzzzz");
        } catch (InterruptedException e) {
            System.out.println("进入catch InterruptedException");
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println("进入catch ExecutionException");
            e.printStackTrace();
        }catch ( TimeoutException e){
            System.out.println("进入catch TimeoutException");
            e.printStackTrace();
        }

    }
}
