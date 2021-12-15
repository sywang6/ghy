package org.ghy.multiThreadFrame.ch10.ch02_01.eg1;

public class Thread1B extends Thread{
    private MyService1 service1;

    public Thread1B(MyService1 service1) {
        this.service1 = service1;
    }
    public void run(){
        for (int i = 0; i < 100000; i++) {
            service1.map.put("ThreadB"+(i+1),"ThreadB"+(i+1));
            System.out.println("ThreadB"+(i+1));
        }
    }
}
