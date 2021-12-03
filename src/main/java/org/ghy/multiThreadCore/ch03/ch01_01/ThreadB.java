package org.ghy.multiThreadCore.ch03.ch01_01;

public class ThreadB extends Thread{

    private MyList list;
    public ThreadB(MyList list){
        this.list = list;
    }

    public void run(){
        try{
            while (true){
                if(list.size()==5){
                    System.out.println("==5了,线程b要退出了!");
                    throw new InterruptedException();
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
