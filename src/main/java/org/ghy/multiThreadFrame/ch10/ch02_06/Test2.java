package org.ghy.multiThreadFrame.ch10.ch02_06;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        MyServiceB serviceB = new MyServiceB();
        ThreadB[] threadBS = new ThreadB[100];

        for (int i = 0; i < threadBS.length; i++) {
            threadBS[i] = new ThreadB(serviceB);
        }
        for (int i = 0; i < threadBS.length; i++) {
            threadBS[i].start();
        }
        //我在测试的时候并没有出现异常情况,导是出现过最后总数不足10000的情况
        Thread.sleep(3000);
        System.out.println(MyServiceB.list.size());
        System.out.println("可以随机取得值:"+MyServiceB.list.get(5));
    }
}
