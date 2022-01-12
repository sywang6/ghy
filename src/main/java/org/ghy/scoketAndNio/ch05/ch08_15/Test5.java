package org.ghy.scoketAndNio.ch05.ch08_15;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//多线程环境下删除键集中的键会导致ConcurrentModificationException
public class Test5 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("abc1");
        set.add("abc2");
        set.add("abc3");
        set.add("abc4");
        set.add("abc5");
        set.add("abc6");
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    set.remove("abc3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            try {
                Thread.sleep(1000);
                iterator.next();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
