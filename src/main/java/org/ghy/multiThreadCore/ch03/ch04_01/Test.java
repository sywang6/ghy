package org.ghy.multiThreadCore.ch03.ch04_01;

/**
 * ThreadLocal不具备继承的特性,这里的继承与类的继承不是一个概念.这里的继承
 * 指父线程与子线程.A线程创建了B线程,则A线程是B线程的父线程,B线程是A线程的子线程
 */
public class Test {
    public static void main(String[] args) {

        try {
            for (int i = 0; i < 10; i++) {
                if(Tools.t1.get()==null){
                    Tools.t1.set("此值是main线程放入的");
                }
                System.out.println(" 在main线程中取值="+Tools.t1.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA a = new ThreadA();
            a.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
