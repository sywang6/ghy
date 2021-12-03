package org.ghy.multiThreadCore.ch03.ch01_18;

public class Add {

    private String lock;

    public Add(String lock){
        this.lock = lock;
    }

    public void add(){
        synchronized (lock){
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
