package org.ghy.multiThreadCore.ch01.ch01_11.ch02;



public class Run2 {

    public static void main(String[] args){
        try{
            //中断当前线程(main线程)
            Thread.currentThread().interrupt();
            //判断当前线程是否中断,并清除线程中断标记
            System.out.println("是否停止1?="+Thread.interrupted());
            //中断标记已经清除,并且没有再次设置中断标记,所以这次返回的是false
            System.out.println("是否停止2?="+Thread.interrupted());
            //是否停止1?=true
            //是否停止2?=false
        }catch(Exception e){
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }

}
