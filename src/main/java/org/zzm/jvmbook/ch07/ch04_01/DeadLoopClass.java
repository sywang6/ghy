package org.zzm.jvmbook.ch07.ch04_01;

public   class DeadLoopClass {
    static class DeadLoop {
        static {
            if (true){
                System.out.println(Thread.currentThread()+"init DeadLoopClass");
                while (true){

                }
            }

        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread()+"start");
                DeadLoop dlc = new DeadLoop();
                System.out.println(Thread.currentThread()+"run over");
            }
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }


}

