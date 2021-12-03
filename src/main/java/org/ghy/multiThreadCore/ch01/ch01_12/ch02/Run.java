package org.ghy.multiThreadCore.ch01.ch01_12.ch02;

/**
 * 这个程序想表达的观点就是,suspend()不会释放锁资源
 */
public class Run {
    public static void main(String[] args) {
        try{

            final SynchronizedObject object = new SynchronizedObject();
            Thread thread1 = new Thread(){
              public void run(){
                  object.printString();
              }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2 = new Thread(){
                public void run(){
                  System.out.println("thread2启动,但进入不了printString,因为a线程未释放锁");
                    object.printString();
                }
            };
            thread2.start();
        }catch (Exception e){

            e.printStackTrace();

        }

    }
}
