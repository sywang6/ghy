package org.zzm.jvmbook.ch07.ch03;

/**
 * 通过子类引用父类的静态字段,不会导致子类初始化.对应静态字段(非常量),只有直接定义这个字段的类才会被初始化.
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
