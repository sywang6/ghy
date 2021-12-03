package org.ghy.multiThreadCore.ch03.ch02_01;

public class Test {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();

            //稍微跟踪一下join的源码,就会发下join内部是由wait()方法实现的.来捋一下这个过程:
            //1.已知:wait()方法是需要在同步代码块或者同步方法里面调用的.
            //join()调用了join(long millis),join(long millis)也确实是一个同步方法.
            //2.既然是同步方法那锁对象是哪个呢?也就是在哪个对象头上设置的标记位
            //非静态的同步方法,是在this对象上设置锁标记的,也就是哪个对象调用了wait()方法,在这里是myThread
            //3.那个线程进入了waiting状态了?
            //正在执行wait()方法的线程进入waiting状态, 显然是main线程调用了wait()方法,所以main线程进入waiting状态
            //main()方法->myThread.join()->myThread.join(0)->myThread.wait()方法
            //4.一个推测: myThread代表的线程执行完成之后(run方法返回或者异常终止),会通知所有在等待这个线程锁的线程
            myThread.join();
            System.out.println("我想当myThread执行完毕我在执行,我做到了");
        }catch (InterruptedException e){
            e.printStackTrace();
        }



    }
}
