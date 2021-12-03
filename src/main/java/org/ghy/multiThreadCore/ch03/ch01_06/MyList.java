package org.ghy.multiThreadCore.ch03.ch01_06;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    public static List list = new ArrayList<>();

    public static void add(){
        list.add("anyString");
    }
    public static int size(){
        return list.size();
    }
}
