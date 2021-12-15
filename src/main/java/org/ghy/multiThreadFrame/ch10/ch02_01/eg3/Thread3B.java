package org.ghy.multiThreadFrame.ch10.ch02_01.eg3;

public class Thread3B extends Thread{
    private MyService3 service1;

    public Thread3B(MyService3 service1) {
        this.service1 = service1;
    }
    public void run(){
        for (int i = 0; i < 100000; i++) {
            service1.map.put("ThreadB"+(i+1),"ThreadB"+(i+1));
            System.out.println("ThreadB"+(i+1));
        }
    }
}
