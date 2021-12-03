package org.ghy.multiThreadCore.ch03.ch01_17;

public class MyRun2 {
    private String lock = new String("");

    /**
     * 是不是先运行了通知
     */
    private boolean isFirstNotify = false;

    private Runnable runnableA = new Runnable() {
        @Override
        public void run() {
           try{
               synchronized (lock){
                   //没有先运行通知,才执行这个逻辑
                   while (isFirstNotify==false){
                       System.out.println("begin wait");
                       lock.wait();
                       System.out.println("end wait");
                   }

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
                    //执行了通知
                    isFirstNotify = true;
                }

        }
    };

    public static void main(String[] args) {
        MyRun2 run = new MyRun2();
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

