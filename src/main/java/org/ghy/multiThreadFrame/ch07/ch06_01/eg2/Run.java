package org.ghy.multiThreadFrame.ch07.ch06_01.eg2;

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
            list.add(new MyCallableB());
            ExecutorService service = Executors.newCachedThreadPool();
            //如果超时,会给所有线程(所有指正在执行任务的线程?还是线程池的线程)设置中断标记
            String getString = service.invokeAny(list,1, TimeUnit.SECONDS);
            System.out.println("zzzz="+getString);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
