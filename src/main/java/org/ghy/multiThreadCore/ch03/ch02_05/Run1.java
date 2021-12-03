package org.ghy.multiThreadCore.ch03.ch02_05;

public class Run1 {
    public static void main(String[] args) {
        try{
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            b.start();
            b.join(200);
            System.out.println(" main end "+System.currentTimeMillis());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
/**
 * 输出下面的这情况不容易分析到:
 * begin A ThreadName=Thread-1 1637227680231
 * end A ThreadName=Thread-1 1637227680734
 *  begin B ThreadName=Thread-0 1637227680734
 *  main end 1637227680734
 *  end B ThreadName=Thread-0 1637227681242
 *  在这个程序中有两把锁ThreadB和PrintStream(是一个同步方法), 下面就来分析上述输出出现的一种可能情况:
 *  时刻1:main线程抢到ThreadB锁,执行wait(),释放ThreadB锁,等待线程B执行完
 *  时刻2: 线程A执行run方法,拿到ThreadB锁
 *  时刻3:线程B在等待ThreadB锁,执行run方法
 *  时刻4:main线程等b线程200ms时间到了, 也进入等待ThreadB锁
 *  时刻5: 线程Arun方法执行完成,释放ThreadB锁
 *  时刻6:main线程获取到ThreadB锁,join方法结束,释放ThreadB锁,并且需要拿到PrintStream锁才能继续执行打印
 *  时刻7:线程B拿到ThreadB锁,也进入PrintStream锁的竞争,并且竞争到了PrintStream锁
 *  时刻8:线程B打印开始,并释放PrintStream锁
 *  时刻9: 面线程拿到PrintStream锁打印
 *  时刻10:线程B打印结束
 *
 *
 */
