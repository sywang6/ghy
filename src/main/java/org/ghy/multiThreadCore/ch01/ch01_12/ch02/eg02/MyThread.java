package org.ghy.multiThreadCore.ch01.ch01_12.ch02.eg02;

public class MyThread extends  Thread{

    private static  long i = 0L;

    public void run(){
        while (true){
            i++;
            System.out.println(i+"");
        }


    }


}
