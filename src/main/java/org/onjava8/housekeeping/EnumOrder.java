package org.onjava8.housekeeping;

public class EnumOrder {
    public static void main(String[] args) {
        System.out.println( Spiciness.values().getClass());

        for (Spiciness s: Spiciness.values()) {
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
}
