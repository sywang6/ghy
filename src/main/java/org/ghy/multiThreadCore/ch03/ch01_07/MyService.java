package org.ghy.multiThreadCore.ch03.ch01_07;

public class MyService {

    private Object  lock = new Object();
    private  MyList list = new MyList();

    public void waitMethod(){
        try{
            synchronized (lock){
                if(list.size()!=5){
                    System.out.println("wait begin "+System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end "+System.currentTimeMillis());
                }

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }


    public void notifyMethod(){
        try{
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    list.add();
                    if (list.size() == 5) {
                        lock.notify();
                        System.out.println("已发出通知!");
                    }
                    System.out.println("添加了" + (i + 1) + "个元素");
                    Thread.sleep(1000);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


    }

}
