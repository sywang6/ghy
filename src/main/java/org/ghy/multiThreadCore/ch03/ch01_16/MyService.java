package org.ghy.multiThreadCore.ch03.ch01_16;

public class MyService {

    public  void testMethod(){
        try{
            synchronized (this){
                System.out.println("wait begin "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
                //wait释放锁,过5秒钟会尝试获得锁,如果拿到锁了,就继续向下执行,时间没到或者没有竞争到锁,还是处于timed waiting状态
                wait(5000);
                System.out.println("wait end "+ Thread.currentThread().getName()+" "+System.currentTimeMillis());
                Thread.sleep(1000);
                Thread.currentThread().interrupt();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
synchronized  public void longTimeSyn(){
        try {
            Thread.sleep(8000);
            //Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
}



}
