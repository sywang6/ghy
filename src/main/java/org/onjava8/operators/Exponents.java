package org.onjava8.operators;

public class Exponents {
    public static void main(String[] args) {
// 大写E 和小写e 的效果相同:
        float expFloat = 1.39e-43f;
        expFloat = 1.39E-43f;
        System.out.println(expFloat);
        double expDouble = 47e47d; // 'd' 是可选的
        double expDouble2 = 47e47; // 自动转换为double
        System.out.println(expDouble);
    }
}
