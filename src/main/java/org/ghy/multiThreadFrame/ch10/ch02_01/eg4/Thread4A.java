package org.ghy.multiThreadFrame.ch10.ch02_01.eg4;

import java.util.Iterator;

public class Thread4A extends  Thread{
    private MyService4 myService4;

    public Thread4A(MyService4 myService4) {
        this.myService4 = myService4;
    }

    public void run(){

        try {
            Iterator iterator = MyService4.hashtable.keySet().iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
