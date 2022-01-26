package org.zzm.jvmbook.ch08;

import java.io.Serializable;

/**
 * 重载方法匹配优先级: 完全匹配->自动类型转换->装箱类型->装箱类型向上转换->可变参数
 */
public class Overload {
    public  static void sayHello(Object arg){
        System.out.println("hello Object");
    }
 /*   public  static void sayHello(int arg){
        System.out.println("hello int");
    }*/
  /*  public  static void sayHello(long arg){
        System.out.println("hello long");
    }*/
    public  static void sayHello(Character arg){
        System.out.println("hello Character");
    }
  /*  public  static void sayHello(char arg){
        System.out.println("hello char");
    }*/
    public  static void sayHello(char... arg){
        System.out.println("hello char...");
    }
    public  static void sayHello(Serializable arg){
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
