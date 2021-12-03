package org.ghy.multiThreadFrame.ch05.ch02_02;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private int age;

    public MyCallable(int age) {
        this.age = age;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(8000);
        return "返回值 年龄是: "+age;
    }
}
