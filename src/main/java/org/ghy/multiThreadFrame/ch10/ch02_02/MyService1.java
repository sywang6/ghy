package org.ghy.multiThreadFrame.ch10.ch02_02;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MyService1 {

    public ConcurrentSkipListMap map = new ConcurrentSkipListMap();

    public MyService1() {
        map.put(new Userinfo(1,"username1"),"value1");
        map.put(new Userinfo(3,"username1"),"value3");
        map.put(new Userinfo(5,"username1"),"value5");
        map.put(new Userinfo(4,"username1"),"value4");
        map.put(new Userinfo(2,"username1"),"value2");
    }
}
