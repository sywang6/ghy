package org.onjava8.operators;

public class BaseType {

   static int a =1;
    static int b =a;

    public static void main(String[] args) {
        System.out.println("a="+a);
        System.out.println("b="+b);
        a = 2;
        //基础类型的赋值为值的复制,赋值过后修改a的值对b的值没有影响,修改b的值对a也没有影响
        System.out.println("a="+a);
        System.out.println("b="+b);
        b = 3;
        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}
