package org.ghy.multiThreadCore.ch03.ch01_07;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    public static List list = new ArrayList<>();

    public  void add(){
        list.add("anyString");
    }
    public  int size(){
        return list.size();
    }
}
