package org.ghy.multiThreadFrame.ch10.ch02_07;

public class Test1 {
    public static void main(String[] args) {
        try {
            MyServiceA serviceA = new MyServiceA();
            ThreadA[] threadAS = new ThreadA[100];

            for (int i = 0; i < threadAS.length; i++) {
                threadAS[i] = new ThreadA(serviceA);
            }
            for (int i = 0; i < threadAS.length; i++) {
                threadAS[i].start();
            }
            Thread.sleep(3000);
            //期望set里面有1000个元素,实际上可能没有
            System.out.println(MyServiceA.set.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
