package org.ghy.multiThreadCore.ch03.ch01_05;

public class Test {
    public static void main(String[] args) {

        try {
            Object lock = new Object();
            MyThread1 myThread1 = new MyThread1(lock);
            myThread1.start();
            //先启动myThread1线程,执行完wait()方法会释放lock锁,等待其他线程通知唤醒,重新竞争锁,才能继续向后执行
            Thread.sleep(3000);
            MyThread2 myThread2 = new MyThread2(lock);
            //myThread2执行完notify(),发送一次通知,唤醒等待lock锁的线程.
            //注意:notify()不会立即释放锁,要等同步代码块执行完才释放锁,所以等待lock锁的线程不会立即竞争到
            //锁继续执行, 若有多个线程同时等待这把lock锁,只有一个线程能获得
            myThread2.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
