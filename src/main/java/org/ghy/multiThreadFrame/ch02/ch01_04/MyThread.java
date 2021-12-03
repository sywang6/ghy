package org.ghy.multiThreadFrame.ch02.ch01_04;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{
    private CountDownLatch comingTag;
    private  CountDownLatch waitTag;
    private  CountDownLatch waitRunTag;
    private CountDownLatch beginTag;
    private CountDownLatch endTag;

    public MyThread(CountDownLatch comingTag, CountDownLatch waitTag, CountDownLatch waitRunTag, CountDownLatch beginTag, CountDownLatch endTag) {
        this.comingTag = comingTag;
        this.waitTag = waitTag;
        this.waitRunTag = waitRunTag;
        this.beginTag = beginTag;
        this.endTag = endTag;
    }

    public  void run(){
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+"运动员使用不同交通工具不同速度到达起跑点,正向这头走!");
            Thread.sleep((int)(Math.random()*10000));
            System.out.println(threadName+"到起跑点了!");
            comingTag.countDown();
            System.out.println(threadName+"等待裁判说准备!");
            waitTag.await();
            System.out.println(threadName+"各就各位!准备起跑姿势!");
            Thread.sleep((int)(Math.random()*10000));
            waitRunTag.countDown();
            beginTag.await();
            System.out.println(threadName+"运动员起跑.并且跑赛过程用时不确定");
            Thread.sleep((int)(Math.random()*10000));
            endTag.countDown();
            System.out.println(threadName+"运动员到达终点");


        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
