package org.ghy.multiThreadCore.ch01.ch01_12.ch03;

/**
 * 用这个例子来说明,suspend()方法会导致数据不一致,我觉得不是很合理.即使setValue()没有暂停,也可能
 * 出现数据不一致的情况,因为printUsernamePassword()和setValue()没有实现同步.
 * suspend()暂停线程真正的问题在于: 暂停的线程不会释放锁,且只能由执行suspend()的线程调用resume()唤醒暂停的线程,容易造成死锁.可能会存在一些恶意的暂停
 * 举个例子: 一个线程调用了suspend()方法,暂停了当前线程,这个线程占用了大量的系统资源.别的线程还没办法中断这个线程,直达这个线程执行了resume()方法.
 * wait(),notify()是一个更好的机制
 *
 *
 *
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {

        final MyObject myObject = new MyObject();
        Thread thread1 = new Thread(){
          public void run(){
              myObject.setValue("a","aa");
          }
        };
        thread1.setName("a");
        thread1.start();
        Thread.sleep(500);
        Thread thread2 = new Thread(){
          public void run(){
              myObject.printUsernamePassword();
          }
        };
        thread2.start();
    }


}
