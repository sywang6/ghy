package org.ghy.multiThreadFrame.ch10.ch02_01.eg4;

public class Thread4B extends Thread{
    private  MyService4 myService4;

    public Thread4B(MyService4 myService4) {
        this.myService4 = myService4;
    }
    public void run(){
        MyService4.hashtable.put("z","zValue");
    }

}
