package org.ghy.multiThreadCore.ch03.ch04_05;

/**
 * InheritableThreadLocal具有继承的特性
 */
public class Test {
    public static void main(String[] args) {

        try {
            for (int i = 0; i < 10; i++) {
                if(Tools.t1.get()==null){
                    Tools.t1.set("此值是main线程放入的");
                }
                System.out.println(" 在main线程中取值="+ Tools.t1.get());
                Thread.sleep(100);
            }
            ThreadA a = new ThreadA();
            a.start();
            Thread.sleep(3000);
            for (int i = 0; i < 10; i++) {
                System.out.println("main end get value="+Tools.t1.get());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
