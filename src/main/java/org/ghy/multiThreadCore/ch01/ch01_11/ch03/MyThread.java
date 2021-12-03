package org.ghy.multiThreadCore.ch01.ch01_11.ch03;

public class MyThread extends  Thread{

    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (Thread.interrupted()) {
                    System.out.println("已经是停止状态了!我要退出了");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("run end");
        }catch (InterruptedException e){
            System.out.println("run 方法中的catch");
            e.printStackTrace();
        }
    }
    }




