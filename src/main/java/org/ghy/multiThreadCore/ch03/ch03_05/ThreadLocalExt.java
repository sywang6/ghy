package org.ghy.multiThreadCore.ch03.ch03_05;

import java.time.LocalDateTime;

public class ThreadLocalExt extends  ThreadLocal{

    @Override
    protected Object initialValue() {
        return  LocalDateTime.now();
    }
}
