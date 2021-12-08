package org.ghy.multiThreadFrame.ch09.ch09_15;

import java.util.concurrent.ForkJoinPool;

public class Run1_1 {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        for (int i = 0; i < 9; i++) {
            pool.submit(new MyRecursiveTask1());
        }
        System.out.println("并行数getParallelism() "+pool.getParallelism()+" 线程池大小getPoolSize() "+pool.getPoolSize());
        pool.shutdown();
        do{

        }while (!pool.isTerminated());
        System.out.println("main end");
    }
}
