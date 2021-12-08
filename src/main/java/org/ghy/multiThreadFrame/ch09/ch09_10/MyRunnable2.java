package org.ghy.multiThreadFrame.ch09.ch09_10;

public class MyRunnable2 implements  Runnable{
    @Override
    public void run() {

            for (int i = 0; i < Integer.MAX_VALUE/20; i++) {
                String newString = new String();
                for (int j = 0; j < 6; j++) {
                    Math.random();
                }

            }
            System.out.println("任务成功完成!");

    }
}
