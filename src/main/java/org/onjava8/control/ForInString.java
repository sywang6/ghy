package org.onjava8.control;

public class ForInString {
    public static void main(String[] args) {
        for(char c: "An African Swallow".toCharArray())
            System.out.print(c + " ");
    }
}
