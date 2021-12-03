package org.ghy.multiThreadCore.ch03.ch03_02;

public class Test {
    public static void main(String[] args) {
        ThreadLocal local = new ThreadLocal();
        local.set("我是任意值");
        System.out.println(local.get());
    }
}
