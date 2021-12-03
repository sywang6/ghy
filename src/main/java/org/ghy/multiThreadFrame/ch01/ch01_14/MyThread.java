package org.ghy.multiThreadFrame.ch01.ch01_14;

public class MyThread extends  Thread{

    private  ListPool listPool;

    public MyThread(ListPool listPool) {
        this.listPool = listPool;
    }
    public  void run(){

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String getString = listPool.get();
            System.out.println(Thread.currentThread().getName()+"取得值:"+getString);
            listPool.put(getString);
        }

    }
}
