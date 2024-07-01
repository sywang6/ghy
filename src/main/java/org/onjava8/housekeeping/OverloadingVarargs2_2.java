package org.onjava8.housekeeping;

public class OverloadingVarargs2_2 {

    static void f(Float i, Character... args) {
        System.out.println("first");
    }
    static void f(Character... args) {
        System.out.println("second");
    }
    public static void main(String[] args) {
        f(1f, 'a');
        f('a', 'b');
    }
}
