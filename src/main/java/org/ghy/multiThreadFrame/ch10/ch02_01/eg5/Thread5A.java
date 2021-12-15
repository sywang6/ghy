package org.ghy.multiThreadFrame.ch10.ch02_01.eg5;

import java.util.Iterator;

public class Thread5A extends Thread{
    private  MyService5 myService5;

    public Thread5A(MyService5 myService5) {
        this.myService5 = myService5;
    }

    @Override
    public  void run(){
        try {
            Iterator iterator = myService5.map.keySet().iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
