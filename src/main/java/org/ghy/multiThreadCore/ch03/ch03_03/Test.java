package org.ghy.multiThreadCore.ch03.ch03_03;

public class Test {
    public static void main(String[] args) {
        MyThreadA a = new MyThreadA();
        MyThreadB b = new MyThreadB();
        a.start();
        b.start();
        try {
            for (int i = 0; i < 10; i++) {
                Tools.t1.set("main" + (i + 1));
                System.out.println("main get" + Tools.t1.get());
                int sleepvalue = (int) (Math.random() * 1000);
                Thread.sleep(sleepvalue);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
