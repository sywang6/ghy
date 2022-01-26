package org.zzm.jvmbook.ch08;

/**
 * 方法静态分派演示
 */
public class StaticDispatch {
    static abstract  class Human{

    }
    static class Man extends Human{

    }
    static  class Woman extends Human{

    }
    public void sayHello(Human guy){
        System.out.println("hello,guy!");
    }
    public  void sayHello(Man guy){
        System.out.println("hello ,gentleman!");
    }
    public void sayHello(Woman guy){
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        //方法重载,编译期就确定了调用了哪个方法
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }
}
