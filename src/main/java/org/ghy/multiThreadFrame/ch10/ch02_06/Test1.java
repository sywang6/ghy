package org.ghy.multiThreadFrame.ch10.ch02_06;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        MyServiceA serviceA = new MyServiceA();
        ThreadA[] threadAS = new ThreadA[100];

        for (int i = 0; i < threadAS.length; i++) {
            threadAS[i] = new ThreadA(serviceA);
        }
        for (int i = 0; i < threadAS.length; i++) {
            threadAS[i].start();
        }
        //我在测试的时候并没有出现异常情况,导是出现过最后总数不足10000的情况
        Thread.sleep(3000);
        System.out.println(MyServiceA.list.size());

    }
}
