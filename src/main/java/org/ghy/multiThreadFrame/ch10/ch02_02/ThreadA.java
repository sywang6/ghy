package org.ghy.multiThreadFrame.ch10.ch02_02;


import java.util.Map;

public class ThreadA extends  Thread{
    private  MyService1 service1;
    public ThreadA(MyService1 service1){
        this.service1 =service1;
    }
    public void run(){
        try {
            while (!service1.map.isEmpty()){
               Map.Entry entry =  service1.map.pollFirstEntry();
               Userinfo userinfo =   (Userinfo) entry.getKey();
                System.out.println(userinfo.getId()+" "+userinfo.getUsername()+" "+entry.getValue());
                Thread.sleep((long)(Math.random()*1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
