package org.ghy.multiThreadFrame.ch10.ch02_01.eg1;

public class Thread1A extends Thread{
    private MyService1 service1;

    public Thread1A(MyService1 service1) {
        this.service1 = service1;
    }
    public void run(){
        for (int i = 0; i < 100000; i++) {
            service1.map.put("ThreadA"+(i+1),"ThreadA"+(i+1));
            System.out.println("ThreadA"+(i+1));
        }
    }
}
