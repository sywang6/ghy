package org.ghy.multiThreadFrame.ch10.ch02_01.eg5;

import java.util.Iterator;

public class Thread5B extends Thread{
    private  MyService5 myService5;

    public Thread5B(MyService5 myService5) {
        this.myService5 = myService5;
    }

    @Override
    public  void run(){
      myService5.map.put("Z","zValue");
    }
}
