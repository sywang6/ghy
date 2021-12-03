package org.ghy.multiThreadFrame.ch05.ch02_08;





import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Run {
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();
        ((ThreadPoolExecutor)service).setRejectedExecutionHandler(new MyRejectExecutionHandler());
        service.submit(new MyRunnable("A"));
        service.submit(new MyRunnable("B"));
        service.submit(new MyRunnable("C"));
        service.shutdown();
        service.submit(new MyRunnable("D"));

    }
}
