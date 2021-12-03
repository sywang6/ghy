package org.ghy.multiThreadCore.ch01.ch01_11.ch01;

public class MyThread extends Thread{


public void run(){
    super.run();
    for(int i=0;i<500000;i++){
        System.out.println("i="+(i+1));
    }
    /*try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }*/
}

}
