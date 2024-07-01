package org.onjava8.housekeeping;

public class PassingThis {
    public static void main(String[] args) {
        new Person().eat(new Apple());
    }
}
