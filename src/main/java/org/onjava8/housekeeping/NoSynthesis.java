package org.onjava8.housekeeping;

public class NoSynthesis {
    public static void main(String[] args) {
//- Bird2 b = new Bird2(); // No default
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2(1.0);
    }
}
