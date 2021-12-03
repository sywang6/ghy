package org.ghy.multiThreadCore.ch03.ch01_01;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    volatile  private List list = new ArrayList<>();

    public void add(){
        list.add("高洪岩");
    }

    public int size(){
        return list.size();

    }

}
