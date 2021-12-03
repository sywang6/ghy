package org.ghy.multiThreadFrame.ch02.ch01_04;

import java.util.concurrent.CountDownLatch;

public class Run {
    public static void main(String[] args) {
        try {
            CountDownLatch comingTag = new CountDownLatch(10);
            CountDownLatch waitTag = new CountDownLatch(1);
            CountDownLatch waitRunTag = new CountDownLatch(10);
            CountDownLatch beginTag = new CountDownLatch(1);
            CountDownLatch endTag = new CountDownLatch(10);

            //10个运动员,main线程充当裁判的角色
            MyThread[] threads = new MyThread[10];
            for (int i = 0; i < threads.length; i++) {
                  threads[i] = new MyThread(comingTag,waitTag,waitRunTag,beginTag,endTag);
                  threads[i].setName("runner"+(i+1));
                  threads[i].start();
              }
            System.out.println("裁判员在等待选手的到来!");
            comingTag.await();
            System.out.println("裁判看到所有运动员来了,各就给位前巡视用时5秒");
            Thread.sleep(5);
            System.out.println("各就各位!");
            waitTag.countDown();
            waitRunTag.await();
            Thread.sleep(2000);
            System.out.println("发令枪响起!");
            beginTag.countDown();
            endTag.await();
            System.out.println("所有运动员到达,统计比赛名次!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
