package org.ghy.multiThreadCore.ch03.ch03_05;

/**
 * 验证initialValue的含义, initialValue是给ThreadLocal的一个默认值.如果调用了ThreadLocal.set()方法,get方法获取的就是
 * set方法设置的值,set设置的值被remove了,get方法返回的仍然是initialValue
 */
public class Run {
    private static ThreadLocalExt tx = new ThreadLocalExt();
    public static void main(String[] args) {
        System.out.println(tx.get());
        tx.remove();
        System.out.println(tx.get());
        tx.set("set1");
        tx.set(null);
        System.out.println(tx.get());
        System.out.println(tx.get());
        tx.remove();
        System.out.println(tx.get());
    }
}
