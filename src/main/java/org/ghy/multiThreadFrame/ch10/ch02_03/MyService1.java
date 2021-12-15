package org.ghy.multiThreadFrame.ch10.ch02_03;



import java.util.concurrent.ConcurrentSkipListSet;

public class MyService1 {
    public ConcurrentSkipListSet set = new ConcurrentSkipListSet();

    public MyService1() {
        set.add(new Userinfo(1,"username1"));
        set.add(new Userinfo(3,"username3"));
        set.add(new Userinfo(5,"username5"));
        set.add(new Userinfo(4,"username4"));
        set.add(new Userinfo(4,"username4"));
        set.add(new Userinfo(2,"username2"));
    }
}
