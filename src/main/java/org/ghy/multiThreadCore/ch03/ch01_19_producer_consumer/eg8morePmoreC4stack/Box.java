package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg8morePmoreC4stack;

import java.util.ArrayList;
import java.util.List;

public class Box {
 private  static List<String> list = new ArrayList<>();

 synchronized public void add(){
     if(size()<50){
         list.add("anyString");
         System.out.println("线程:"+Thread.currentThread().getName()+
                 "执行add()方法,size大小为:"+size());
     }
 }

 synchronized public int size(){
     return list.size();
 }

 synchronized  public Object popFirst(){
     Object value = list.remove(0);
     System.out.println("线程: "+Thread.currentThread().getName()+"执行" +
             "popFirst()方法,size大小为: "+size());

     return value;
 }

}
