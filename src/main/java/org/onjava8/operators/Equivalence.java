package org.onjava8.operators;

public class Equivalence {
    public static void main(String[] args) {
        Integer n1 = 47;
        Integer n2 = 47;
        Integer n3 = 128;
        Integer n4 = 128;
        Short n5 = 47;
        Short n6 = 47;
        Double n7 = 127D;
        Double n8 = 127D;
        System.out.println(n1 == n2);
        System.out.println(n1 != n2);
        System.out.println(n3 == n4);
        System.out.println(n3 != n4);
        System.out.println(n5 == n6);
        System.out.println(n5 != n6);
        System.out.println(n7 == n8);
        System.out.println(n7 != n8);
    }
}
