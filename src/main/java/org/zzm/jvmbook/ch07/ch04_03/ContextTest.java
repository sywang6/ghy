package org.zzm.jvmbook.ch07.ch04_03;

public class ContextTest {
    public static void main(String[] args) {
        //当前线程的上下文类加载器,其实就是线程的一个属性,默认是应用程序类加载器(系统类加载器)
        System.out.println(Thread.currentThread().getContextClassLoader());
        //Thread的类加载器,在lang包,那当然是启动类加载器加载的
        System.out.println(Thread.currentThread().getClass().getClassLoader());
        //输出:
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        //null
    }
}
