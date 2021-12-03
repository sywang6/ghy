package org.ghy.multiThreadCore.ch03.ch01_17;

public class MyRun {
    private String lock = new String("");

    private Runnable runnableA = new Runnable() {
        @Override
        public void run() {
           try{
               synchronized (lock){
                   System.out.println("begin wait");
                   lock.wait();
                   System.out.println("end wait");
               }
           }catch (InterruptedException e){
               e.printStackTrace();
           }
        }
    };

    private Runnable runnableB = new Runnable() {
        @Override
        public void run() {
                synchronized (lock){
                    System.out.println("begin notify");
                    lock.notify();
                    System.out.println("end notify");
                }

        }
    };

    public static void main(String[] args) {
        MyRun run = new MyRun();
        Thread a = new Thread(run.runnableA);
        Thread b = new Thread(run.runnableB);
        //先执行了notify,在执行wait,wait永久的错过了通知,程序不会结束
        b.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.start();
    }

}

