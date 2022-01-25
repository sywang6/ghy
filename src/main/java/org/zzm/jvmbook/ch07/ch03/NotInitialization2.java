package org.zzm.jvmbook.ch07.ch03;

/**
 * 通过数组定义引用类,不会触发此类的初始化.
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
        //触发了[Lorg.zzm.jvmbook.ch07.ch03.SuperClass类的初始化,这个类虚拟机自动生成的
    }
}
