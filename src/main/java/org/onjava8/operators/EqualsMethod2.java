package org.onjava8.operators;

public class EqualsMethod2 {
    public static void main(String[] args) {
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        System.out.println(v1.equals(v2));
    }
}
// operators/EqualsMethod2.java
// 默认的equals() 方法没有比较内容
class Value {
    int i;
}