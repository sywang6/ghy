package org.ghy.multiThreadFrame.ch01.ch01_03;

import java.util.concurrent.Semaphore;

/**
 * addPermitsCount,每次调用release()就添加一个许可证,许可证的数量可以超过初始许可证的数量
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        System.out.println(""+semaphore.availablePermits());
        semaphore.release();
        semaphore.release(2);
        System.out.println(""+semaphore.availablePermits());
        semaphore.acquire();
        System.out.println(""+semaphore.availablePermits());

    }
}
